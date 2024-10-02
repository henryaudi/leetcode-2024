package com.henry.leetcode.problems.oct_01_24;

import java.util.Map;
import java.util.HashMap;

/**
 * First program created for testing purpose
 */
public class Problem001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
