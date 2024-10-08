package com.henry.leetcode.tests;

import com.henry.leetcode.problems.oct_07_24.Problem567;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Oct07Test {

    @Test
    public void problem567Test() {

        Problem567 pb = new Problem567();

        String s1 = "ab", s2 = "eidboaoo";
        boolean res = pb.checkInclusion(s1, s2);

        Assertions.assertEquals(false, res, "Test failed");
    }
}
