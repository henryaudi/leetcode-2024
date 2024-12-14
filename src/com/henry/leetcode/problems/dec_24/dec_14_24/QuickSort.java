package com.henry.leetcode.problems.dec_24.dec_14_24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSort {
    /**
     * @problemId ---
     * @problemName QuickSort Algorithm
     * @difficulty Medium
     * @topics Sort
     * @date 12/14/2024
     * @Notes This is an implementation of quick sort algorithm.
     */
    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // Determine the 2 pointers and pivot for quick sort algorithm.
        int left = start, right = end;
        int pivot = arr[left + (right - left) / 2];

        // We don't want left and right pointer quit at the same number
        // from the array, thus, == condition should be also part of the while
        // condition.
        while (left <= right) {
            // To be balanced, say [1,1,1,1,1,1,2], if we use <=,
            // the left partition can be too big.
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                // Swap and move the pointers.
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }

    @Test
    public void test01() {
        int[] arr = {2, 3, 1, 7, 7, 12, 5};
        int[] res = {1, 2, 3, 5, 7, 7, 12};

        sort(arr);

        Assertions.assertArrayEquals(arr, res, "Test failed");
    }
}
