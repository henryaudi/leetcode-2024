package com.henry.leetcode.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.henry.leetcode.problems.oct_24.oct_01_24.Problem001TwoSum;
import org.junit.jupiter.api.Test;

public class Problem001TwoSumTest {

    @Test
    public void testTwoSum_Success() {
        Problem001TwoSum problem = new Problem001TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = problem.twoSum(nums, target);

        // Test case where solution exists
        assertArrayEquals(new int[]{0, 1}, result, "The indices should be [0, 1]");
    }

    @Test
    public void testTwoSum_NoSolution() {
        Problem001TwoSum problem = new Problem001TwoSum();

        int[] nums = {1, 2, 3, 4};
        int target = 10;
        int[] result = problem.twoSum(nums, target);

        // Test case where no valid solution exists
        assertArrayEquals(new int[]{-1, -1}, result, "Should return [-1, -1] when no solution exists");
    }
}