/*
 * Feature 9 - Genre Mapping - PROBLEM - Letter Combinations of a Phone Number
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    public void backtrack(int index, StringBuilder path, String digits, Map<Character, String[]> letters, List<String> combinations) {
        if(path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String[] possibleLetters = letters.get(digit);
        for(String letter: possibleLetters) {
            path.append(letter);
            backtrack(index + 1, path, digits, letters, combinations);
            path.deleteCharAt(path.length() - 1);
        }
    }

     public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }
        //  Mapping the digits to their corresponding letters
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[]{""});
        digitsMapping.put('2', new String[]{"a", "b", "c"});
        digitsMapping.put('3', new String[]{"d", "e", "f"});
        digitsMapping.put('4', new String[]{"g", "h", "i"});
        digitsMapping.put('5', new String[]{"j", "k", "l"});
        digitsMapping.put('6', new String[]{"m", "n", "o"});
        digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
        digitsMapping.put('8', new String[]{"t", "u", "v"});
        digitsMapping.put('9', new String[]{"w", "x", "y", "z"});
        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);

        return combinations;
    }
}
