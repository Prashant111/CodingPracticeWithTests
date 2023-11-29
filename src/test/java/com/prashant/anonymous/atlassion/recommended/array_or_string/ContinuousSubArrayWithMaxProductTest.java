package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContinuousSubArrayWithMaxProductTest {

    ContinuousSubArrayWithMaxProduct continuousSubArrayWithMaxProduct;

    @BeforeEach
    void setUp() {
        continuousSubArrayWithMaxProduct = new ContinuousSubArrayWithMaxProduct();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validSubArrayCount() {
        assertEquals(7, continuousSubArrayWithMaxProduct.validSubArrayCount(new int[]{1, 2, 3, 4}, 10));
        assertEquals(16, continuousSubArrayWithMaxProduct.validSubArrayCount(new int[]{1, 9, 2, 8, 6, 4, 3}, 100));
        assertEquals(8, continuousSubArrayWithMaxProduct.validSubArrayCount(new int[]{10, 5, 2, 6}, 100));
        assertEquals(5, continuousSubArrayWithMaxProduct.validSubArrayCount(new int[]{5, 3, 2}, 16));
    }
}