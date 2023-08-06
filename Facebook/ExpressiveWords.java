/*
 * Feature 5 - Check if words can be morphed to other profane words - PROBLEM - Expressive Words
 */

package Facebook;

public class ExpressiveWords {
    class Solution {
        public int expressiveWords(String s, String[] words) {
            if (s == null || words == null) {
                return 0;
            }

            int expressiveCount = 0;
            for (String word : words) {
                if (isExpressive(s, word)) {
                    expressiveCount++;
                }
            }

            return expressiveCount;
        }

        private boolean isExpressive(String s, String word) {
            int i = 0;
            int j = 0;

            while (i < s.length() && j < word.length()) {
                char currentChar = s.charAt(i);
                int len1 = repeatedLetters(s, i);
                int len2 = repeatedLetters(word, j);

                if (currentChar != word.charAt(j)) {
                    return false;
                }

                if ((len1 < 3 && len1 != len2) || (len1 >= 3 && len2 > len1)) {
                    return false;
                }

                i += len1;
                j += len2;
            }

            return i == s.length() && j == word.length();
        }

        private int repeatedLetters(String s, int ind) {
            int temp = ind;
            char c = s.charAt(ind);
            while (temp < s.length() && s.charAt(temp) == c) {
                temp++;
            }
            return temp - ind;
        }
    }

}
