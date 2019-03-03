package com.bermaker.test.algorithms;

import org.junit.Assert;
import org.junit.Test;

import com.bermaker.algorithms.mathematics.Numbers;

public class MatheMaticsTest {

    private Numbers numbers = new Numbers();

    @Test
    public void testSingleNumber() {
        int[] nums = {2, 2, 1};
        int ret = numbers.singleNumber(nums);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testMajorityElement() {
        int[] nums = {3, 2, 3};
        int ret1 = numbers.majorityElement(nums);
        int ret2 = numbers.majorityElement1(nums);
        Assert.assertEquals(3, ret1);
        Assert.assertEquals(3, ret2);
        int[] nums1 = {3, 3, 4};
        ret1 = numbers.majorityElement(nums1);
        ret2 = numbers.majorityElement1(nums1);
        Assert.assertEquals(3, ret1);
        Assert.assertEquals(3, ret2);
    }

}
