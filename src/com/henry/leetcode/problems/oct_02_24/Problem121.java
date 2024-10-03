package com.henry.leetcode.problems.oct_02_24;

public class Problem121 {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
     * future to sell that stock.
     *
     * @param prices: array of prices at different days
     *
     *  @return: max profit
     *
     */
    public int maxProfit(int[] prices) {

        int prevMin = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            prevMin = Math.min(prices[i], prevMin);
            res = Math.max(prices[i] - prevMin, res);
        }

        return res;
    }
}
