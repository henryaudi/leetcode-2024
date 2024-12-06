package com.henry.leetcode.problems.dec_24.dec_05_24;

public class QuickSort {
    /**
     * @problemId ---
     * @problemName QuickSort Algorithm
     * @difficulty Medium
     * @topics Merge Sort
     * @date 12/05/2024
     * @Notes This is an implementation of quick sort algorithm.
     */
    public void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = arr[(start + end) / 2];

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
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
}
