package com.henry.leetcode.problems.oct_24.oct_14_24;
/**
 * @problemId ---
 * @problemName MergeSort Algorithm
 * @difficulty Medium
 * @topics Merge Sort
 * @date 10/15/2024
 * @Notes This is an implementation of merge sort algorithm.
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        helper(nums, 0, nums.length - 1, temp);
    }

    private void helper(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        helper(nums, start, (start + end) / 2, temp);
        helper(nums, (start + end) / 2 + 1, end, temp);
        merge(nums, start, end, temp);
    }

    private void merge(int[] nums, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = start;

        while (leftIndex <= middle && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            } else {
                temp[index++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = nums[rightIndex++];
        }

        for (int i = start; i < end; i++) {
            nums[i] = temp[i];
        }
    }

}
