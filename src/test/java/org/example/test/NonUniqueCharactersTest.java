package org.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilities.StringUtils.EMPTY_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonUniqueCharactersTest {

    private NonUniqueCharacters nonUniqueCharacters;

    @BeforeEach
    void setUp() {
        nonUniqueCharacters = new NonUniqueCharacters();
    }

    @Test
    void getUniqueCharacters() {
        String actual = nonUniqueCharacters.getUniqueCharacters("abcab");
        assertEquals("ab", actual);
    }

    @Test
    void getUniqueCharactersForNullInputString() {
        String actual = nonUniqueCharacters.getUniqueCharacters(null);
        assertEquals(EMPTY_STRING, actual);
    }

    @Test
    void getUniqueCharactersForEmptyInputString() {
        String actual = nonUniqueCharacters.getUniqueCharacters(EMPTY_STRING);
        assertEquals(EMPTY_STRING, actual);
    }
}