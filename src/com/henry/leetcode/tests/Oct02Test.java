package com.henry.leetcode.tests;

import com.henry.leetcode.problems.oct_02_24.Problem121;
import com.henry.leetcode.problems.oct_02_24.Problem714;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Oct02Test {

    @Test
    public void testProblem714001() {

        Problem714 pb714 = new Problem714();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = pb714.maxProfit(prices, fee);

        // Test result against correct answer, 8.
        Assertions.assertEquals(8, res, "Test failed");
    }

    @Test
    public void testProblem714002() {

        Problem714 pb714 = new Problem714();

        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        int res = pb714.maxProfit(prices, fee);

        // Test result against correct answer, 6.
        Assertions.assertEquals(6, res, "Test failed");
    }

    @Test
    public void testProblem121() {

        Problem121 pb121 = new Problem121();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = pb121.maxProfit(prices);

        Assertions.assertEquals(5, res, "Test failed!");
    }
}
