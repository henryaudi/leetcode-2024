package com.henry.leetcode.problems.oct_24.oct_09_24;

/**
 * LeetCode Problem 165 Compare Version Numbers
 *
 * Given two version strings, version1 and version2, compare them. A version string
 * consists of revisions separated by dots '.'. The value of the revision is its integer
 * conversion ignoring leading zeros.
 * To compare version strings, compare their revision values in left-to-right order. If
 * one of the version strings has fewer revisions, treat the missing revision values as 0.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * @problemId 165
 * @problemName Compare Version Numbers
 * @difficulty Medium
 * @topics String, Regex
 * @date 10/09/2024
 * @Notes To split a string by '.', we use `version1.split("\\.");`.
 */
public class Problem165 {
    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");

        int len = Math.max(versionArr1.length, versionArr2.length);

        for (int i = 0; i < len; i++) {
            int subVersion1 = -1, subVersion2 = -1;

            if (i >= versionArr1.length) {
                subVersion1 = 0;
            } else {
                subVersion1 = Integer.parseInt(versionArr1[i]);
            }

            if (i >= versionArr2.length) {
                subVersion2 = 0;
            } else {
                subVersion2 = Integer.parseInt(versionArr2[i]);
            }

            if (subVersion1 > subVersion2) { return 1; }
            if (subVersion1 < subVersion2) { return -1; }
        }

        return 0;
    }
}
