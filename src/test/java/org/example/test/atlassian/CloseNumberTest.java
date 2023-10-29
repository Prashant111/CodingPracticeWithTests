package org.example.test.atlassian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloseNumberTest {

    private CloseNumber closeNumber;

    @BeforeEach
    void setUp() {
        closeNumber = new CloseNumber();
    }

    @Test
    void testCloseNumbersNullInput() {
        assertThrows(NullPointerException.class, () -> closeNumber.containsCloseNumbers(null));
    }

    @Test
    void testCloseNumbersEmptyInput() {
        assertFalse(closeNumber.containsCloseNumbers(new int[0]));
    }

    @Test
    void testCloseNumbersContainsOnlyZero() {
        assertFalse(closeNumber.containsCloseNumbers(new int[]{0}));
    }

    @Test
    void testCloseNumbersContainsSingleNumber() {
        assertFalse(closeNumber.containsCloseNumbers(new int[]{2}));
    }

    @Test
    void testCloseNumbersContainsSingleNegativeNumber() {
        assertFalse(closeNumber.containsCloseNumbers(new int[]{-20}));
    }

    @Test
    void testCloseNumbersContainsDuplicateNumber() {
        assertFalse(closeNumber.containsCloseNumbers(new int[]{1, 1}));
    }

    @Test
    void testCloseNumbersContainConsecutiveCloseNumber() {
        assertTrue(closeNumber.containsCloseNumbers(new int[]{1, 2}));
    }

    @Test
    void testCloseNumbersContainNonConsecutiveCloseNumber() {
        assertTrue(closeNumber.containsCloseNumbers(new int[]{1, 20, 15, 19}));
    }

    @Test
    void testCloseNumbersContainNoCloseNumber() {
        assertFalse(closeNumber.containsCloseNumbers(new int[]{1, 20, 15, 17}));
    }
}