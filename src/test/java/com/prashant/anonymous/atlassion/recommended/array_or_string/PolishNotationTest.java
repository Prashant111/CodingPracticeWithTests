package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolishNotationTest {

    private final String normalInput = "21+3*";
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValueAsPerPolishNotation() {
        int actual = new PolishNotation(normalInput).getValueAsPerPolishNotation();
        assertEquals(9, actual);
    }
}