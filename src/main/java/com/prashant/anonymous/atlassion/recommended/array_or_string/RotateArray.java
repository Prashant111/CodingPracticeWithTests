package com.prashant.anonymous.atlassion.recommended.array_or_string;

import com.prashant.anonymous.common.exception.EmptyInputException;
import com.prashant.anonymous.common.exception.InvalidInputException;
import com.prashant.anonymous.common.exception.NullInputException;

import java.util.Arrays;
import java.util.Objects;

public class RotateArray {
    private final int[] input;
    private final int k;

    public RotateArray(int[] input, int k) {
        validateInputs(input, k);
        this.input = input;
        this.k = k;
    }

    private void validateInputs(int[] input, int k) {
        if (Objects.isNull(input))
            throw new NullInputException();
        if (input.length == 0)
            throw new EmptyInputException();
        if (k < 0)
            throw new InvalidInputException(k);
    }

    public int[] rotatedArray() {
        int[] doubledSize = new int[input.length * 2];
        System.arraycopy(input, 0, doubledSize, 0, input.length);
        System.arraycopy(input, 0, doubledSize, input.length, input.length);

        return Arrays.copyOfRange(doubledSize, k % input.length, k % input.length + input.length);
    }

}
