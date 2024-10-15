package com.henry.leetcode.tests;

import com.henry.leetcode.problems.oct_24.oct_14_24.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Oct14Test {

    @Test
    public void testMergeSort01() {
        int[] nums = {3, 4, 1, 7, 2, 9, 5, 12};
        int[] res = {1, 2, 3, 4, 5, 7, 9, 12};

        MergeSort ms = new MergeSort();
        ms.mergeSort(nums);

        Assertions.assertArrayEquals(res, nums, "Test failed");
    }
}
