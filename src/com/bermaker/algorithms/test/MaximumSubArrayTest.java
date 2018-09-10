/**
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 * @Title: MaximumSubArrayTest.java
 * @Package: com.bermaker.algorithms.test
 * @Desc: maximum sub array algorithm
 * @author: yuzhongchun
 * @date: 2018年9月10日 下午6:11:25
 * @version 1.0
 */
package com.bermaker.algorithms.test;

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

    public static void main(String[] args) {
        int[] A = { 3, -4, 2, 4, -1, 5, 3, -6, 2, 1, -2 };
        MaximumSubArray msa = new MaximumSubArray();
        MsaRet ret = msa.findMaxSubArray(A, 0, A.length - 1);
        System.out.println(ret.getLow() + " -> " + ret.getHigh() + " => " + ret.getSum());
    }

}
