package org.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestNonRepeatingSubstringTest {

    private LongestNonRepeatingSubstring longestNonRepeatingSubstring;

    @BeforeEach
    void setUp() {
        longestNonRepeatingSubstring = new LongestNonRepeatingSubstring();
    }

    @Test
    void getLongestNonRepeatingSubstringLength() {
        assertEquals(0, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength(null));
        assertEquals(0, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength(""));
        assertEquals(4, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("abcd"));
        assertEquals(3, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("abcabcabc"));
        assertEquals(5, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("abcdae"));
        assertEquals(1, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("aaaaa"));
        assertEquals(4, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("abccabcd"));
        assertEquals(4, longestNonRepeatingSubstring.getLongestNonRepeatingSubstringLength("abcdb"));
    }
}