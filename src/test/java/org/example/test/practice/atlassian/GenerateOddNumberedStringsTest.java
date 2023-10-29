package org.example.test.practice.atlassian;

import org.example.test.atlassian.GenerateOddNumberedStrings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

class GenerateOddNumberedStringsTest {

    private GenerateOddNumberedStrings generateOddNumberedStrings;

    @BeforeEach
    void setUp() {
        generateOddNumberedStrings = new GenerateOddNumberedStrings();
    }

    @Test
    void oddNumberedStringNegativeEvenLength() {
        assertOddOccurrencesForLength(-10);
    }

    private void assertOddOccurrencesForLength(int givenLength) {
        String string = generateOddNumberedStrings.oddNumberedString(givenLength);
        int evenCount = getEvenCount(string);
        assertFalse(evenCount > 0);
    }

    private static int getEvenCount(String string) {
        int evenCount = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : string.toCharArray()) {
            int newValue = charCountMap.getOrDefault(c, 0) + 1;
            charCountMap.put(c, newValue);
            evenCount = isEven(newValue) ? evenCount + 1 : evenCount - 1;
        }
        return evenCount;
    }

    private static boolean isEven(int newValue) {
        return (newValue & 1) == 0;
    }

    @Test
    void oddNumberedStringNegativeOddLength() {
        assertOddOccurrencesForLength(-11);
    }

    @Test
    void oddNumberedStringForZeroLength() {
        assertOddOccurrencesForLength(0);
    }

    @Test
    void oddNumberedStringForOddLength() {
        assertOddOccurrencesForLength(11);
    }

    @Test
    void oddNumberedStringForEvenLength() {
        assertOddOccurrencesForLength(10);
    }

    @Test
    void oddNumberedStringForVeryLargeNumber() {
        assertOddOccurrencesForLength(1_000_000);
    }
}