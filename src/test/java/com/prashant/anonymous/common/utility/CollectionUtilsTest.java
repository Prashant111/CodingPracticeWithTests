package com.prashant.anonymous.common.utility;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    void isNotNullButEmptyCollectionEmptyTest() {
        assertFalse(CollectionUtils.isNotNullButEmpty(null));
    }

    @Test
    void isZeroSizedCollectionEmptyTest() {
        assertTrue(CollectionUtils.isNotNullButEmpty(Arrays.asList()));
    }

    @Test
    void nonZeroSizedCollectionEmptyTest() {
        assertFalse(CollectionUtils.isNotNullButEmpty(Arrays.asList("One element")));
    }

    @Test
    void isNotNullButEmptyTest() {
        assertTrue(CollectionUtils.isNotNullButEmpty(Collections.emptyList()));
    }

    @Test
    void isNullTest() {
        assertTrue(CollectionUtils.isNull(null));
    }

    @Test
    void isNullNegativeTest() {
        assertFalse(CollectionUtils.isNull(new ArrayList()));
    }

    @Test
    void isNotNullTest() {
        assertFalse(CollectionUtils.isNotNull(null));
    }

    @Test
    void isNotNullNegativeTest() {
        assertTrue(CollectionUtils.isNotNull(new ArrayList()));
    }

    @Test
    void isNullOrEmptyForNullInputTest() {
        assertTrue(CollectionUtils.isNullOrEmpty(null));
    }

    @Test
    void isNullOrEmptyForEmptyInputTest() {
        assertTrue(CollectionUtils.isNullOrEmpty(new ArrayList()));
    }

    @Test
    void isNullOrEmptyForNonEmptyInputTest() {
        assertFalse(CollectionUtils.isNullOrEmpty(Arrays.asList("Non empty collection")));
    }

    @Test
    void isNonEmptyForNonEmptyTest() {
        assertTrue(CollectionUtils.isNonEmpty(Arrays.asList("Non empty collection")));
    }

    @Test
    void isNonEmptyForNullTest() {
        assertFalse(CollectionUtils.isNonEmpty(null));
    }

    @Test
    void isNonEmptyForEmptyTest() {
        assertFalse(CollectionUtils.isNonEmpty(Arrays.asList()));
    }
}