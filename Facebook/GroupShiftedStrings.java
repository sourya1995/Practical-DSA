/*
 * Feature #6 - Combine similar messages - PROBLEM - Group Shifted Strings
 */

package Facebook;

import java.util.*;

public class GroupShiftedStrings {
    public static List<List<String>> combineMessages(String[] messages){
        Map<String, List<String>> messageGroup = new HashMap<>();
        for(String message : messages){
            String key = generateKey(message);
            List<String> list = messageGroup.getOrDefault(key, new ArrayList<>());
            list.add(message);
            messageGroup.put(key, list);
        }

        return new ArrayList<>(messageGroup.values());
    }

    public static String generateKey(String message){
        char[] chars = message.toCharArray();
        String key = "";
        for(int i = 0; i < chars.length; i++){
            int diff = chars[i] - chars[i - 1];

            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}
