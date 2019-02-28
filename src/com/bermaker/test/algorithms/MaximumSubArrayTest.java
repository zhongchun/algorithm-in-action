/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Test;

import com.bermaker.algorithms.maximumsubarray.MaximumSubArray;
import com.bermaker.algorithms.maximumsubarray.MsaRet;

/**
 * @ClassName: MaximumSubArrayTest
 * @Desc: test maximum sub array algorithm
 * @author: yuzhongchun
 * @date: 2018年9月10日 下午6:11:25
 * 
 */
public class MaximumSubArrayTest {

    @Test
    public void testSubArray() {
        int[] A = { 3, -4, 2, 4, -1, 5, 3, -6, 2, 1, -2 };
        MaximumSubArray msa = new MaximumSubArray();
        MsaRet ret = msa.findMaxSubArray(A, 0, A.length - 1);
        System.out.println(ret.getLow() + " -> " + ret.getHigh() + " => " + ret.getSum());
    }

}
