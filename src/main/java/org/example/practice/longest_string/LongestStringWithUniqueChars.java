package org.example.practice.longest_string;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithUniqueChars {
    public int longestStringWithoutRepeatingCharacters(String string) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int lastIndex = 0;
        int result = 0;

        for (int i = 0; i < string.length(); i++) {
            lastIndex = Math.max(lastIndex, charIndex.getOrDefault(string.charAt(i), -1));
            result = Math.max(result, i - lastIndex);
            charIndex.put(string.charAt(i), i);
        }

        return result;
    }
}
