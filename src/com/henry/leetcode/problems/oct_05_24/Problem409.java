package com.henry.leetcode.problems.oct_05_24;

/**
 *
 * LeetCode Problem 409: Longest Palindrome
 * <p>
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome that can be built with those letters.
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome.
 * <p>
 * URL: <a href="https://leetcode.com/problems/longest-palindrome/description/">LEETCODE409</a>
 * <p>
 * Difficulty: EASY
 *
 */
public class Problem409 {

    /**
     * Find the longest palindrome using the characters from s.
     * @param s the input string
     * @return the length of the longest palindrome generated using
     *         the characters given from string s
     */
    public int longestPalindrome(String s) {

        char[] characters = s.toCharArray();
        int[] letters = new int[52];
        int res = 0;
        boolean foundOdd = false;

        for (char c : characters) {
            letters[c < 'a' ? c - 'A' : c - 'a' + 26]++;
        }

        for (int num : letters) {
            res += num / 2 * 2;
            if (num % 2 == 1) { foundOdd = true; }
        }

        res += foundOdd == true ? 1 : 0;

        return res;
    }
}
