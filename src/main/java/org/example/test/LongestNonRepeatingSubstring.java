package org.example.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Problem statement:

 */
public class LongestNonRepeatingSubstring {
    public int getLongestNonRepeatingSubstringLength(String input) {
        if (Objects.isNull(input))
            return 0;

        int result = 0;
        Map<Character, Integer> characterIndexMap = new HashMap<>();
        char[] chars = input.toCharArray();

        int lastRepeatedCharacterIndex = -1;
        for (int currentIndex = 0; currentIndex < chars.length; currentIndex++) {
            char currentChar = chars[currentIndex];
            lastRepeatedCharacterIndex = Math.max(lastRepeatedCharacterIndex,
                                                  characterIndexMap.getOrDefault(currentChar, -1)
                                                 );
            characterIndexMap.put(currentChar, currentIndex);
            result = Math.max(result, currentIndex - lastRepeatedCharacterIndex);
        }
        return result;
    }
}
