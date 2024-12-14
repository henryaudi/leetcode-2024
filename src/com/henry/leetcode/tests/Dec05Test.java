package com.henry.leetcode.tests;

import com.henry.leetcode.problems.dec_24.dec_12_24.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class Dec05Test {
    @Test
    public void test01() {
        int[] arr = {2, 2, 2, 2, 2, 2, 2};
        int[] res = {2, 2, 2, 2, 2, 2, 2};

        QuickSort qs = new QuickSort();
        qs.sort(arr);

        Assertions.assertArrayEquals(arr, res, "Test failed");
    }

    @Test
    public void test02() {
        for (int i = 0; i < 1000; i += 100) {
            int[] randomNumbers = new int[i];
            Random random = new Random();

            for (int j = 0; j < i; j++) {
                randomNumbers[j] = random.nextInt();
            }

            int[] arr = Arrays.copyOf(randomNumbers, randomNumbers.length);

            // Sort using Arrays method.
            Arrays.sort(randomNumbers);

            // Sort using quickSort.
            QuickSort qs = new QuickSort();
            qs.sort(arr);

            Assertions.assertArrayEquals(arr, randomNumbers, "Test failed");
        }
    }
}
