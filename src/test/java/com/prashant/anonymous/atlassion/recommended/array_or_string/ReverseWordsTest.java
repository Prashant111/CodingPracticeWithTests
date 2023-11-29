package com.prashant.anonymous.atlassion.recommended.array_or_string;

import com.prashant.anonymous.common.exception.EmptyInputException;
import com.prashant.anonymous.common.exception.NullInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    private final String normalInput = "ye hai meri kahani";
    private final String onlyStringInput = "yeHaiMeriKahani";
    private final String variableSpacesStringInput = "ye    hai meri kahani";
    private final String inputWithTabsStringInput = "ye\thai\tmeri\tkahani";
    private final String inputWithSpacesInStart = "   ye hai meri kahani";
    private final String inputWithSpacesInEnd = "ye hai meri kahani   ";
    private final String inputWithSpacesInStartAndEnd = "   ye hai meri kahani   ";
    private final String inputWithVariableSpacesAndTabsInput = "ye  \thai\t      meri   \t   kahani";
    private final String nullInput = null;
    private final String emptyInput = "";
    private final String onlyWhiteSpacesInput = "   \t";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseWordsNormal() {
        String actual = new ReverseWords(normalInput).reverseWords();
        assertEquals("kahani meri hai ye", actual);
    }

    @Test
    void reverseWordsWithOnlyStringInput() {
        String actual = new ReverseWords(onlyStringInput).reverseWords();
        assertEquals(onlyStringInput, actual);
    }

    @Test
    void reverseWordsWithVariableSpacesInput() {
        String actual = new ReverseWords(variableSpacesStringInput).reverseWords();
        assertEquals("kahani meri hai    ye", actual);
    }

    @Test
    void reverseWordsWithTabsStringInput() {
        String actual = new ReverseWords(inputWithTabsStringInput).reverseWords();
        assertEquals("kahani\tmeri\thai\tye", actual);
    }

    @Test
    void reverseWordsWithSpacesInStartInput() {
        String actual = new ReverseWords(inputWithSpacesInStart).reverseWords();
        assertEquals("kahani meri hai ye   ", actual);
    }

    @Test
    void reverseWordsWithSpacesInEndInput() {
        String actual = new ReverseWords(inputWithSpacesInEnd).reverseWords();
        assertEquals("   kahani meri hai ye", actual);
    }

    @Test
    void reverseWordsWithSpacesInStartAndEndInput() {
        String actual = new ReverseWords(inputWithSpacesInStartAndEnd).reverseWords();
        assertEquals("   kahani meri hai ye   ", actual);
    }

    @Test
    void reverseWordsWithVariableSpacesAndTabsInput() {
        String actual = new ReverseWords(inputWithVariableSpacesAndTabsInput).reverseWords();
        assertEquals("kahani   \t   meri      \thai\t  ye", actual);
    }

    @Test
    void reverseWordsWithNullInput() {
        assertThrows(NullInputException.class, () -> new ReverseWords(nullInput).reverseWords());
    }

    @Test
    void reverseWordsWithEmptyInput() {
        assertThrows(EmptyInputException.class, () -> new ReverseWords(emptyInput).reverseWords());
    }

    @Test
    void reverseWordsWithOnlyWhiteSpacesInput() {
        assertThrows(EmptyInputException.class, () -> new ReverseWords(onlyWhiteSpacesInput).reverseWords());
    }

}