package org.example.utilities;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static <T> T requireValidValue(T value, boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
