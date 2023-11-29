package com.prashant.anonymous.atlassion.recommended.array_or_string;


import com.prashant.anonymous.common.exception.EmptyInputException;
import com.prashant.anonymous.common.exception.InvalidInputException;
import com.prashant.anonymous.common.exception.NullInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    RotateArray rotateArray;

    @BeforeEach
    void setUp() {
        rotateArray = new RotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rotatedArray() {
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, rotateArray.rotatedArray());
    }

    @Test
    void rotatedArrayWithZeroKValue() {
        int[] input = {1, 2, 3};
        assertArrayEquals(input, new RotateArray(input, 0).rotatedArray());
    }

    @Test
    void rotatedArrayWithKGreaterThanInputLength() {
        int k = 3;
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int[] rotatedArrayWithK = new RotateArray(input, k).rotatedArray();
        int[] rotatedArrayWithKPlusLength = new RotateArray(input, k + input.length).rotatedArray();
        assertArrayEquals(rotatedArrayWithK, rotatedArrayWithKPlusLength, "rotated array with k and k added length should be equal");
    }


    @Test
    void rotatedArrayNullInput() {
        assertThrows(
                NullInputException.class,
                () -> new RotateArray(null, 3),
                "Expected Null Input exception to throw, but it didn't");
    }

    @Test
    void rotatedArrayEmptyInput() {
        assertThrows(EmptyInputException.class, () -> new RotateArray(new int[]{}, 4), "Expected Empty input exception but we did not get that.");
    }

    @Test
    void rotatedArrayWithValidInputButNegativeKValue() {
        assertThrows(InvalidInputException.class, () -> new RotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, -2), "Expected Invalid Input exception but we did not get that.");
    }

    @Test
    void rotatedArrayWithNullInputAndNegativeKValue() {
        assertThrows(NullInputException.class, () -> new RotateArray(null, -2), "Expected Null Input exception but we did not get that.");
    }

    @Test
    void rotatedArrayWithEmptyInputAndNegativeKValue() {
        assertThrows(EmptyInputException.class, () -> new RotateArray(new int[]{}, -2), "Expected Empty Input exception but we did not get that.");
    }

}