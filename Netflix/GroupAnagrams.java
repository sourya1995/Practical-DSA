/*
 * Feature 1 - Group valid names together - this problem is GROUP ANAGRAMS
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public static List<List<String>> groupTitles(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> res = new HashMap<String, List<String>>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                int index = c - 'a'; // calculate relative position of the String item
                count[index]++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<String>());
            }
            res.get(key).add(str);

        }
        return new ArrayList<List<String>>(res.values());
    }
}