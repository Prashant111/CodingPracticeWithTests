package com.prashant.anonymous.common.utility;

import java.util.Collection;

public class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isNotNullButEmpty(Collection<?> collection) {
        return ObjectUtils.isNotNull(collection) && collection.isEmpty();
    }

    public static boolean isNull(Collection<?> collection) {
        return ObjectUtils.isNull(collection);
    }

    public static boolean isNotNull(Collection<?> collection) {
        return ObjectUtils.isNotNull(collection);
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return ObjectUtils.isNull(collection) || isNotNullButEmpty(collection);
    }

    public static boolean isNonEmpty(Collection<?> collection) {
        return ObjectUtils.isNotNull(collection) && !collection.isEmpty();
    }
}
