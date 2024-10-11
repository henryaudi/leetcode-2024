package com.henry.leetcode.problems.oct_24.oct_10_24;

/**
 * LeetCode Problem 680 Valid Palindrom II
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * @problemId 680
 * @problemName Valid Palindrome II
 * @difficulty Easy
 * @topics Two Pointers, String
 * @date 10/10/2024
 * @Notes Each time you have 2 characters to choose, either one to remove, that gives you 2 possible strings, try to generate those 2 strings.
 */

public class Problem680 {

    public boolean validPalindrome(String s) {
        if (s == null) { return false; }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) { return false; }
            left++;
            right--;
        }

        return true;
    }
}
