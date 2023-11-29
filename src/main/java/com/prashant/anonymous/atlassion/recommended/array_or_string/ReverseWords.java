package com.prashant.anonymous.atlassion.recommended.array_or_string;

import static com.prashant.anonymous.common.utility.ValidationUtility.validateString;

public class ReverseWords {
    private final String input;

    public ReverseWords(String input) {
        validateString(input);
        this.input = input;
    }

    public String reverseWords() {
        char[] chars = input.toCharArray();
        int lastWordStartIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                reverseWord(chars, lastWordStartIndex, i - 1);
                lastWordStartIndex = i + 1;
            }
        }
        reverseWord(chars, lastWordStartIndex, chars.length - 1);
        reverseWord(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverseWord(char[] chars, int startIndex, int endIndex) {
        for (int i = startIndex; i <= (endIndex + startIndex) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[endIndex + startIndex - i];
            chars[endIndex + startIndex - i] = temp;
        }
    }
}
