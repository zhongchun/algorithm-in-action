/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.search;

import org.junit.Assert;
import org.junit.Test;

import com.bermaker.search.BinarySearch;

/**
 * @ClassName: BinarySearchTest
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/8 10:53 AM
 * @Version: 1.0
 */
public class BinarySearchTest {

    private BinarySearch bs = new BinarySearch();

    @Test
    public void testBinarySearchNum() {
        int[] A = {1};
        int pos = bs.binarySearchNum(A, 1);
        Assert.assertEquals(0, pos);
        pos = bs.binarySearchNum(A, 2);
        Assert.assertEquals(-1, pos);
        int[] B = {0, 1, 2, 3, 5, 13, 25, 38, 91};
        pos = bs.binarySearchNum(B, 100);
        Assert.assertEquals(-1, pos);
        pos = bs.binarySearchNum(B, 0);
        Assert.assertEquals(0, pos);
        pos = bs.binarySearchNum(B, 1);
        Assert.assertEquals(1, pos);
        pos = bs.binarySearchNum(B, 91);
        Assert.assertEquals(8, pos);
    }

    @Test
    public void testFindFisrtLessNum() {
        int[] A = {1};
        int pos = -1;
        pos = bs.findFisrtLessNum(A, 1);
        Assert.assertEquals(-1, pos);
        pos = bs.findFisrtLessNum(A, 2);
        Assert.assertEquals(0, pos);
        int[] B = {-3, 0, 1, 5, 13, 21, 35, 68};
        pos = bs.findFisrtLessNum(B, 20);
        Assert.assertEquals(4, pos);
        pos = bs.findFisrtLessNum(B, 21);
        Assert.assertEquals(4, pos);
        pos = bs.findFisrtLessNum(B, 0);
        Assert.assertEquals(0, pos);
        pos = bs.findFisrtLessNum(B, -2);
        Assert.assertEquals(0, pos);
        pos = bs.findFisrtLessNum(B, 68);
        Assert.assertEquals(6, pos);
        pos = bs.findFisrtLessNum(B, 102);
        Assert.assertEquals(7, pos);
        int[] C = {};
        pos = bs.findFisrtLessNum(C, 1);
        Assert.assertEquals(-1, pos);
        pos = bs.findFisrtLessNum(null, 1);
        Assert.assertEquals(-1, pos);
    }

}
