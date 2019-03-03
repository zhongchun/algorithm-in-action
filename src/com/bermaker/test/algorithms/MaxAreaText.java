/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Before;
import org.junit.Test;

import com.bermaker.algorithms.maxarea.MaxArea;

/**
 * @ClassName: MaxAreaText
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 4:54 PM
 * @Version: 1.0
 */
public class MaxAreaText {

    private MaxArea maxArea;

    @Before
    public void init() {
        maxArea = new MaxArea();
    }

    @Test
    public void testMaxArea() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea.maxArea(height);
        System.out.println("max: " + max);
        max = maxArea.maxArea1(height);
        System.out.println("max1: " + max);
    }

}
