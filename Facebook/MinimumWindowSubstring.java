/*
 * Feature 8 - Find Overlapping Posts - PROBLEM - Minimum window substring
 */

package Facebook;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        if(t.equals(" ")){
            return "";
        }

        Map<Character, Integer> targetCharCount = new HashMap<>();
        Map<Character, Integer> windowCharCount = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            targetCharCount.put(c, 1 + targetCharCount.getOrDefault(c, 0));
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            windowCharCount.put(c, 0);
        }

        int currentCount = 0;
        int requiredCount = targetCharCount.size();

        int[] resultIndices = {-1, -1};
        int resultLength = Integer.MAX_VALUE;

        int leftPtr = 0;
        for(int rightPtr = 0; rightPtr < s.length(); rightPtr++){
            char currentChar = s.charAt(rightPtr);

            if(t.indexOf(currentChar) != -1){
                windowCharCount.put(currentChar, 1 + windowCharCount.getOrDefault(currentChar, 0));
            }

            if(targetCharCount.containsKey(currentChar) && windowCharCount.get(currentChar).equals(targetCharCount.get(currentChar))){
                currentCount += 1;
            }

            while(currentCount == requiredCount){
                if((rightPtr - leftPtr + 1) < resultLength){
                    resultIndices[0] = leftPtr;
                    resultIndices[1] = rightPtr;
                    resultLength = rightPtr - leftPtr + 1;
                }

                char leftChar = s.charAt(leftPtr);
                if(t.indexOf(leftChar) != -1){
                    windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                }

                if(targetCharCount.containsKey(leftChar) && windowCharCount.get(leftChar) < targetCharCount.get(leftChar)){
                    currentCount -= 1;
                }

                leftPtr += 1;
            }
        }
        int leftIndex = resultIndices[0];
        int rightIndex = resultIndices[1];
        return resultLength != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : " ";
    }
}
