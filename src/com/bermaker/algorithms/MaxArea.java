/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.algorithm;

/**
 * @ClassName: MaxArea
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 4:43 PM
 * @Version: 1.0
 */
public class MaxArea {

    /**
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int area = 0;
        int h = 0;
        int w = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                h = Math.min(height[i], height[j]);
                w = j - i;
                area = h * w;
                max = (max < area) ? area : max;
            }
        }
        return max;
    }
}
