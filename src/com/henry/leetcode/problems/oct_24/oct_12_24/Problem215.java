package com.henry.leetcode.problems.oct_24.oct_12_24;
/**
 * LeetCode Problem 215 Valid Palindrom II
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 * @problemId 215
 * @problemName Kth Largest Elenment in an Array
 * @difficulty Medium
 * @topics Two Pointers, Quick Sort
 * @date 10/12/2024
 * @Notes Need to redo this problem, very interesting
 */
public class Problem215 {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[end];
        }

        int left = start, right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        // [start,...,right,left,..k...end]
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        // [start,.k..,right,left,....end]
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }

        // [start,..right,k,left,...end]
        return nums[right + 1];
    }
}
