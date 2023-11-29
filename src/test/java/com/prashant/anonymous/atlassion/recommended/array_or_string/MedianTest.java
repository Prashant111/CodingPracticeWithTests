package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateMedian() {
        assertEquals(1.5, new Median(new int[]{1}, new int[]{2}).calculateMedian());
        assertEquals(2.0, new Median(new int[]{1, 3}, new int[]{2}).calculateMedian());
        assertEquals(2.5, new Median(new int[]{1, 3}, new int[]{2, 4}).calculateMedian());
        assertEquals(6.0, new Median(new int[]{3, 4, 7, 10, 12}, new int[]{2, 3, 6, 15}).calculateMedian());
        assertEquals(5.0, new Median(new int[]{1, 3, 4, 7, 10, 12}, new int[]{2, 3, 6, 15}).calculateMedian());
        assertEquals(8.0, new Median(new int[]{7, 12, 14, 15}, new int[]{1, 2, 3, 4, 9, 11}).calculateMedian());
    }

    @Test
    void calculateMedianSingleNumber() {
        assertEquals(7.0, new Median(new int[]{7}, new int[]{}).calculateMedian());
        assertEquals(7.0, new Median(new int[]{}, new int[]{7}).calculateMedian());
    }

    @Test
    void calculateMedianForNoNumber() {
        assertEquals(-1, new Median(new int[]{}, new int[]{}).calculateMedian());
    }
}