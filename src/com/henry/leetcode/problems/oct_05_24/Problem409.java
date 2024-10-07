package com.henry.leetcode.problems.oct_05_24;

/**
 *
 * Leetcode 409
 * Find the longest palindrome using the characters from s.
 *
 * @problemId 409
 *
 * @problemName Longest Palindrome
 *
 * @difficulty Easy
 *
 * @topics Character, Array
 *
 * @date 10/05/2024
 *
 * @Notes Used an array to represent the number of appearance rather than HashMap to enhance time and space complexity. Notice that in ASCII code, A-Z is 65 - 90, and a-z is 97 - 122
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
