package com.henry.leetcode.problems.oct_07_24;

/**
 * LeetCode Problem 409: Longest Palindrome
 *
 * Given two strings s1 and s2, return true if s2 contains a
 * permutation of s1, or false otherwise. In other words, return
 * true if one of s1's permutations is the substring of s2.
 *
 * @problemId 567
 * @problemName Permutation in String
 * @difficulty Medium
 * @topics Sliding Window
 * @date 10/07/2024
 * @Notes Create a sliding window, every time you move, you remove the first, and add the one after the last.
 */
public class Problem567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { return false; }

        int[] dict1 = new int[26];
        int[] dict2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            dict1[s1.charAt(i) - 'a']++;
            dict2[s2.charAt(i) - 'a']++;
        }

        if (isPermutation(dict1, dict2)) { return true; }

        for (int i = 1; i + s1.length() <= s2.length(); i++) {
            dict2[s2.charAt(i - 1) - 'a']--;
            dict2[s2.charAt(i + s1.length() - 1) - 'a']++;
            if (isPermutation(dict1, dict2)) { return true; }
        }

        return false;
    }

    /**
     * Check if the 2 arrays represents two permutation strings.
     * @param arr1 the first array which includes the number of
     *             appearance of each letter in the first string
     * @param arr2 the second array which includes the number of
     *             appearance of each letter in the second string
     * @return `true` if the two array represents permutation, `false`
     *          otherwise
     */
    private boolean isPermutation(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) { return false; }
        }

        return true;
    }
}
