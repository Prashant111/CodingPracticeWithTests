package org.example.practice.reverse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {

    private ReverseNumber reverseNumber;

    @BeforeEach
    void setUp() {
        reverseNumber = new ReverseNumber();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverse() {
        int reversedNum = reverseNumber.reverse(234234242);
        assertEquals(242432432, reversedNum);

        reversedNum = reverseNumber.reverse(13424);
        assertEquals(42431, reversedNum);
    }

    @Test
    void reverseNegative() {
        int reversedNum = reverseNumber.reverse(-234234242);
        assertEquals(-242432432, reversedNum);
    }

    @Test
    void reverseZero() {
        int reversedNum = reverseNumber.reverse(0);
        assertEquals(0, reversedNum);
    }

}