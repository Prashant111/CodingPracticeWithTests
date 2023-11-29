package com.prashant.anonymous.common.utility;

import java.util.Objects;

public class ObjectUtils {
    private ObjectUtils(){
    }
    public static boolean isNull(Object object) {
        return Objects.isNull(object);
    }

    public static boolean isNotNull(Object object) {
        return Objects.nonNull(object);
    }
}
