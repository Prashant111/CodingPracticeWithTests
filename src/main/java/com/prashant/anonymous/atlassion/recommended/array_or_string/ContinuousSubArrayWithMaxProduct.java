package com.prashant.anonymous.atlassion.recommended.array_or_string;

import com.prashant.anonymous.common.exception.InvalidInputException;
import com.prashant.anonymous.common.exception.NullInputException;

import java.util.Arrays;

import static com.prashant.anonymous.common.utility.ArrayUtils.isEmpty;
import static com.prashant.anonymous.common.utility.ArrayUtils.isNull;

public class ContinuousSubArrayWithMaxProduct {

    public int validSubArrayCount(int[] input, int productLimit) {
        validateInput(input, productLimit);

        if (isEmpty(input)) {
            return 0;
        }

        int count = 0;
        int startIndex = 0;
        int endIndex = 0;

        long p = 1;
        while (startIndex < input.length && endIndex < input.length) {
            p *= input[endIndex];

            while (startIndex < endIndex && p >= productLimit)
                p /= input[startIndex++];

            if (p < productLimit)
                count += (1 + (endIndex - startIndex));

            endIndex++;
        }

        return count;
    }

    private void validateInput(int[] array, int k) {
        if (isNull(array))
            throw new NullInputException();

        boolean nonPositiveNumberExist = Arrays.stream(array).boxed().anyMatch(integer -> (integer <= 0));
        if (nonPositiveNumberExist)
            throw new InvalidInputException(array);

        boolean negativeProductLimit = k < 0;
        if (negativeProductLimit)
            throw new InvalidInputException(k);
    }


}
