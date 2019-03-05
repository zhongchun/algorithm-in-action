/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import java.util.concurrent.atomic.AtomicIntegerArray;

import org.junit.Test;

import com.bermaker.algorithms.arrays.LengthestSubArray;

/**
 * @ClassName: ArraysTest
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/5 10:45 AM
 * @Version: 1.0
 */
public class ArraysTest {

    private LengthestSubArray lengthestSubArray = new LengthestSubArray();

    @Test
    public void testLengthestSubArray() {
        int[] A = {3, 2, 1, 5, 8, 7, 1, 1, 2, 4, 5};
        int sum = 8;
        int len = lengthestSubArray.lengthestSubArray(A, sum);
        System.out.println(len);
    }

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = lengthestSubArray.maxSubArray(nums);
        System.out.println(max);
        max = lengthestSubArray.maxSubArray1(nums);
        System.out.println(max);
    }

    @Test
    public void testMaxProduct() {
        int[] nums = {2, 3, -2, 8, 4, 1};
        int max = lengthestSubArray.maxProduct(nums);
        System.out.println(max);
        max = lengthestSubArray.maxProduct1(nums);
        System.out.println(max);
    }
}
