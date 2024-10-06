package com.henry.leetcode.tests;

import com.henry.leetcode.problems.oct_05_24.Problem409;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Oct05Test {

    @Test
    public void test409Case01() {

        Problem409 pb409 = new Problem409();

        String s = "abccccdd";
        int res = pb409.longestPalindrome(s);

        Assertions.assertEquals(7, res, "Failed");
    }
}
