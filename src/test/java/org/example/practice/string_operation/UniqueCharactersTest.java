package org.example.practice.string_operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.example.utilities.StringUtils.EMPTY_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharactersTest {
    public static final String LONG_STRING = "abcaadbadfsdasdgsfdasfsdfasdgsdfasfsdga";
    public static final String NORMAL_STRING = "abcambbbac";
    private UniqueCharacters uniqueCharacters;

    @BeforeEach
    void setUp() {
        uniqueCharacters = new UniqueCharacters();
    }

    @Test
    void testEmptyString() {
        List<Character> uniqueCharactersList = uniqueCharacters.getUniqueCharacters(EMPTY_STRING);
        assertEquals(Collections.EMPTY_LIST, uniqueCharactersList);
    }

    @Test
    void testUniqueCharactersOnString() {
        List<Character> uniqueCharactersList = uniqueCharacters.getUniqueCharacters(NORMAL_STRING);
        assertEquals(List.of('a', 'b', 'c', 'm'), uniqueCharactersList);
    }

    @Test
    void testUniqueCharactersOnLongString() {
        List<Character> uniqueCharactersList = uniqueCharacters.getUniqueCharacters(LONG_STRING);
        assertEquals(List.of('a', 'b', 'c', 'd', 'f', 's', 'g'), uniqueCharactersList);
    }

    @Test
    void getUniqueCharactersStringOnEmptyString() {
        String actual = uniqueCharacters.getUniqueCharactersString(EMPTY_STRING);
        assertEquals(EMPTY_STRING, actual);
    }

    @Test
    void getUniqueCharactersStringOnGivenString() {
        String actual = uniqueCharacters.getUniqueCharactersString(NORMAL_STRING);
        assertEquals("abcm", actual);
    }

    @Test
    void getUniqueCharactersStringOnLongString() {
        String actual = uniqueCharacters.getUniqueCharactersString(LONG_STRING);
        assertEquals("abcdfsg", actual);
    }
}