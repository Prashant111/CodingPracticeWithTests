package org.example.practice.longest_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestStringWithUniqueCharsTest {

    LongestStringWithUniqueChars longestStringWithUniqueChars;

    @BeforeEach
    void setUp() {
        longestStringWithUniqueChars = new LongestStringWithUniqueChars();
    }

    @Test
    void longestStringWithoutRepeatingCharacters() {
        assertEquals(3, longestStringWithUniqueChars.longestStringWithoutRepeatingCharacters("abcabcabcbb"));
        assertEquals(4, longestStringWithUniqueChars.longestStringWithoutRepeatingCharacters("pwwkey"));
    }
}