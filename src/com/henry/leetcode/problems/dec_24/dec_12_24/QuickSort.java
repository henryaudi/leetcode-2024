package com.henry.leetcode.problems.dec_24.dec_12_24;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) { return; }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int start = left, end = right;
        int pivot = arr[start + (end - start) / 2];  // Avoid overflow

        while (start <= end) {
            while (start <= end && arr[start] < pivot) {
                start++;
            }
            while (start <= end && arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, left, end);
        quickSort(arr, start, right);
    }
}
