package com.henry.leetcode.tests;

import com.henry.leetcode.problems.oct_24.oct_12_24.Problem215;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Oct12Test {
    @Test
    public void problem215Test1() {

        Problem215 pb = new Problem215();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int res =  pb.findKthLargest(nums, 2);

        Assertions.assertEquals(5, res, "Test failed.");
    }

    @Test
    public void problem215Test2() {

        Problem215 pb = new Problem215();

        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int res =  pb.findKthLargest(nums, 20);

        Assertions.assertEquals(2, res, "Test failed.");
    }

    @Test
    public void problem215Test3() {

        Problem215 pb = new Problem215();

        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int res =  pb.findKthLargest(nums, 3);

        Assertions.assertEquals(2, res, "Test failed.");
    }
}
