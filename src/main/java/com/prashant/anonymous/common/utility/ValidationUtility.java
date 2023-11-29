package com.prashant.anonymous.common.utility;

import com.prashant.anonymous.common.exception.EmptyInputException;
import com.prashant.anonymous.common.exception.NullInputException;

public class ValidationUtility {
    private ValidationUtility() {
    }

    public static void validateString(String string) {
        if (StringUtils.isNull(string))
            throw new NullInputException();
        if (StringUtils.isBlank(string))
            throw new EmptyInputException();
    }

    public static void validateArray(int[] sortedArray1) {
        if (ArrayUtils.isNull(sortedArray1)) {
            throw new NullInputException();
        }
    }
}
