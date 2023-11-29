package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringTest {

    private final String[] normalPositiveCombination = new String[]{"egg", "add"};
    private final String[] normalNegativeCombination = new String[]{"foo", "bar"};

    @Test
    void areIsomorphicStringsPositiveTest() {
        boolean actual = new IsomorphicString(normalPositiveCombination[0], normalPositiveCombination[1]).areIsomorphicStrings();
        assertTrue(actual);
    }
    @Test
    void areIsomorphicStringsNegativeTest() {
        boolean actual = new IsomorphicString(normalNegativeCombination[0], normalNegativeCombination[1]).areIsomorphicStrings();
        assertFalse(actual);
    }
}