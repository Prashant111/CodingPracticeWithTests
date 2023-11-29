package com.prashant.anonymous.atlassion.recommended.array_or_string;

import com.prashant.anonymous.common.utility.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.prashant.anonymous.common.utility.ValidationUtility.validateString;

public class IsomorphicString {
    private final String input1;
    private final String input2;

    public IsomorphicString(String input1, String input2) {
        validateString(input1);
        validateString(input2);
        this.input1 = input1;
        this.input2 = input2;
    }

    public boolean areIsomorphicStrings() {
        if (StringUtils.areNotOfSameLength(input1, input2)) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            if (charMap.containsKey(input1.charAt(i)) && charMap.get(input1.charAt(i)) != input2.charAt(i))
                return false;
            charMap.put(input1.charAt(i), input2.charAt(i));
        }
        return true;
    }
}
