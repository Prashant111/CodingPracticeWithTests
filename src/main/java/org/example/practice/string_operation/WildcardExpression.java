package org.example.practice.string_operation;

/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */

import java.util.Objects;

public class WildcardExpression {
    public boolean expressionMatching(String string, String pattern) {
        Boolean dp[][] = new Boolean[string.length() + 1][pattern.length() + 1];
        return expressionMatchingHelper(string, pattern, 0, 0, dp);
    }

    private boolean expressionMatchingHelper(String string, String pattern, int stringIndex, int patternIndex, Boolean[][] dp) {
        int stringLength = string.length();
        int patternLength = pattern.length();
        if (patternIndex == patternLength) {
            return stringIndex == stringLength;
        }

        if (Objects.nonNull(dp[stringIndex][patternIndex]))
            return dp[stringIndex][patternIndex];

        char currentPatternChar = pattern.charAt(patternIndex);

        boolean currentCharMatchingOrDot = (stringIndex < stringLength) && (string.charAt(stringIndex) == currentPatternChar || currentPatternChar == '.');
        if ((patternIndex + 1 < patternLength) && pattern.charAt(patternIndex + 1) == '*') {
            if (expressionMatchingHelper(string, pattern, stringIndex, patternIndex + 2, dp))
                return dp[stringIndex][patternIndex] = true;
            if (currentCharMatchingOrDot)
                return expressionMatchingHelper(string, pattern, stringIndex + 1, patternIndex, dp);
        } else if (currentCharMatchingOrDot)
            return expressionMatchingHelper(string, pattern, stringIndex + 1, patternIndex + 1, dp);

        return dp[stringIndex][patternIndex] = false;
    }
}
