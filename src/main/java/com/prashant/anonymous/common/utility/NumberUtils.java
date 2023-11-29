package com.prashant.anonymous.common.utility;

import com.prashant.anonymous.common.exception.EmptyInputException;

import java.util.Arrays;

public class NumberUtils {
    private NumberUtils() {
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    public static boolean isEven(int number) {
        return !isOdd(number);
    }

    public static double average(int... numbers) {
        if (ArrayUtils.isEmpty(numbers))
            throw new EmptyInputException();
        return Arrays.stream(numbers).average().getAsDouble();

    }
}
