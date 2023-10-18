package org.example.practice.longest_palindrome;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeStringTest {

    private LongestPalindromeString longestPalindromeString;

    @BeforeEach
    void setUp() {
        longestPalindromeString = new LongestPalindromeString();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLongestPalindromicString() {
        String string = "abcbabcb";
        assertEquals("bcbabcb", longestPalindromeString.getLongestPalindromicString(string));

    }
}