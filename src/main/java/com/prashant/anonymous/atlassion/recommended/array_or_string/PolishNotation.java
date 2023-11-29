package com.prashant.anonymous.atlassion.recommended.array_or_string;

import java.util.Stack;

import static com.prashant.anonymous.common.utility.StringUtils.stringContainsString;
import static com.prashant.anonymous.common.utility.ValidationUtility.validateString;

public class PolishNotation {
    private final String input;

    public PolishNotation(String input) {
        validateString(input);
        this.input = input;
    }

    public int getValueAsPerPolishNotation() {
        String ops = "+-*/";
        Stack<String> stack = new Stack<>();
        for (int i = input.length() - 1; i >= 0; i--)
            stack.push(String.valueOf(input.charAt(i)));

        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            if (!stringContainsString(ops, currentChar)) {
                stack.push(currentChar);
            } else {
                Integer value1 = Integer.valueOf(stack.pop());
                Integer value2 = Integer.valueOf(stack.pop());
                int index = ops.indexOf(currentChar);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(value2 + value1));
                        break;
                    case 1:
                        stack.push(String.valueOf(value2 - value1));
                        break;
                    case 2:
                        stack.push(String.valueOf(value2 * value1));
                        break;
                    case 3:
                        stack.push(String.valueOf(value2 / value1));
                        break;
                    default:
                        // do nothing
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
