package org.example.practice.longest_palindrome;

public class LongestPalindromeString {
    public String getLongestPalindromicString(String string) {
        boolean[][] dp = new boolean[string.length()][string.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            dp[i][i] = true;
            dp[i + 1][i] = true;
        }
        dp[string.length() - 1][string.length() - 1] = true;

        for (int diff = 1; diff < string.length(); diff++) {
            for (int i = 0; i < string.length() - diff; i++) {
                dp[i][i + diff] = string.charAt(i) == string.charAt(i + diff) && dp[i + 1][i + diff - 1];
                if (dp[i][i + diff] && diff > (end - start)) {
                    start = i;
                    end = i + diff;
                }
            }
        }
        return string.substring(start, end + 1);
    }
}
