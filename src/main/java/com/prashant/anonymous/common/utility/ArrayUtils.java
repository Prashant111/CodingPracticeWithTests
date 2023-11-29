package com.prashant.anonymous.common.utility;

public class ArrayUtils {
    private ArrayUtils() {
    }
    public static boolean isEmpty(int[] array) {
        return ObjectUtils.isNotNull(array) && array.length == 0;
    }

    public static <T> boolean isEmpty(T[] array) {
        return ObjectUtils.isNotNull(array) && array.length == 0;
    }

    public static boolean isNull(int[] array) {
        return ObjectUtils.isNull(array);
    }

    public static <T> boolean isNull(T[] array) {
        return ObjectUtils.isNull(array);
    }

}
