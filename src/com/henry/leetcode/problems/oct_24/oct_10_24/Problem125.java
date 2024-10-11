package com.henry.leetcode.problems.oct_24.oct_10_24;

/**
 * LeetCode Problem 125 Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers. Given a string s, return true if it is
 * a palindrome, or false otherwise.
 *
 * @problemId 125
 * @problemName Valid Palindrome
 * @difficulty Easy
 * @topics Two Pointers
 * @date 10/10/2024
 * @Notes Get familiar with Character methods, such as Character.toLowerCase(), Character.isDigit(), Character.isLetter()
 */
public class Problem125 {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
            if (!isEqual(s.charAt(left), s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    private boolean isEqual(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
}
