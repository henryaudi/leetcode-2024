package com.henry.leetcode.problems.oct_02_24;

public class Problem714 {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee
     * representing a transaction fee.
     *
     * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay
     * the transaction fee for each transaction.
     *
     * @param prices: the prices at ith day
     * @param fee: the transaction fee generated each time you sell
     * @return: the maximum profit
     */
    public int maxProfit(int[] prices, int fee) {

        // This array is when you decide to sell or not hold.
        int[] free = new int[prices.length];

        // This array is when you decide to buy.
        int[] hold = new int[prices.length];

        hold[0] -= prices[0];

        for (int i = 1; i < prices.length; i++) {
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
        }

        return free[free.length - 1];
    }
}
