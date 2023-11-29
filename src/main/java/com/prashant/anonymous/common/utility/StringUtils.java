package com.prashant.anonymous.common.utility;

public class StringUtils {
    private StringUtils() {
    }
    public static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    public static boolean isBlank(String string) {
        return string.isBlank();
    }

    public static boolean isNull(String string) {
        return ObjectUtils.isNull(string);
    }

    public static boolean stringContainsChar(String string, char character) {
        return string.indexOf(character) >= 0;
    }

    public static boolean stringContainsString(String string, String substring) {
        return string.contains(substring);
    }

    public static boolean areOfSameLength(String string1, String string2) {
        return string1.length() == string2.length();
    }

    public static boolean areNotOfSameLength(String string1, String string2) {
        return !areOfSameLength(string1, string2);
    }

    public static boolean areStringEquals(String string1, String string2) {
        return (isNull(string1) && isNull(string2)) || (!isNull(string1) && !isNull(string2) && string1.equals(string2));
    }
}
