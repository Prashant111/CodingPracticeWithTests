package com.prashant.anonymous.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumUsingJava8Test {

    private SumUsingJava8 sumUsingJava8;

    @BeforeEach
    void setUp() {
        sumUsingJava8 = new SumUsingJava8();
    }

    @Test
    void getSumOfSquareOfEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        long sumOfSquareOfEvenNumbers = sumUsingJava8.getSumOfSquareOfEvenNumbers(numbers);
        assertEquals(56, sumOfSquareOfEvenNumbers);
    }
}