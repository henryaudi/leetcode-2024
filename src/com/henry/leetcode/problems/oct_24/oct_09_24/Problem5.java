package com.henry.leetcode.problems.oct_24.oct_09_24;

/**
 * LeetCode Problem 5 Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * @problemId 5
 * @problemName Longest Palindromic Substring
 * @difficulty Medium
 * @topics Two Pointers
 * @date 10/09/2024
 * @Notes
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) { return s; }

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd number substring
            String oddSub = findOddSubstring(i, s);

            // Even number substring
            String evenSub = findEvenLengthSubstring(i, s);

            String temp = oddSub.length() > evenSub.length() ? oddSub : evenSub;
            res = res.length() > temp.length() ? res : temp;
        }

        return res;
    }

    private String findOddSubstring(int i, String s) {
        int left = i - 1, right = i + 1;
        String res = s.charAt(i) + "";

        while (left >= 0
                && right < s.length()
                && (s.charAt(left) == s.charAt(right))) {
            res = s.substring(left, right + 1);
            left--;
            right++;
        }

        return res;
    }

    private String findEvenLengthSubstring(int i, String s) {
        int left = i, right = i + 1;
        String res = "";

        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            res = s.substring(left, right + 1);
            left--;
            right++;
        }

        return res;
    }
}
