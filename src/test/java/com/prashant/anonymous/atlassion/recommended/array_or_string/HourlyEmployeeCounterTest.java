package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HourlyEmployeeCounterTest {

    @Test
    void hourlyEmployeeCount() {
        HourlyEmployeeCounter hourlyEmployeeCounter = new HourlyEmployeeCounter(new int[][]{
                {1, 2},
                {5, 6},
                {1, 5},
                {3, 1},
        });
        int[] actual = hourlyEmployeeCounter.hourlyEmployeeCount();
        int[] expected = {0, 1, 1, 0, 0, 1, 1};
        System.out.println("Arrays.toString(actual) = " + Arrays.toString(actual));
        System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected));
        assertEquals(expected, actual);
    }
}