package org.example.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void requireValidValueShouldNotThrowExceptions() {
        int age = 30;
        Assertions.assertDoesNotThrow(
                () ->
                        ValidationUtils.requireValidValue(
                                age,
                                age >= 18,
                                "Only adults can access the website"
                                                         ));
    }

    @Test
    void requireValidValueShouldThrowIllegalArgumentException() {
        int age = 5;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () ->
                        ValidationUtils.requireValidValue(
                                age,
                                age >= 18,
                                "Only adults can access the website"
                                                         )
                               );
    }
}