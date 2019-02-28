/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms;

/**
 * @ClassName: Sqrt
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/27 4:55 PM
 * @Version: 1.0
 */
public class Sqrt {

    /**
     * 二分法求解
     * @param num
     *
     * @return
     */
    public float sqrt0(int num) {
        if (num < 0) {
            return 0.0f;
        }
        float l = 0.0f;
        float r = num;
        float v = (l + r) / 2;
        float dot = v * v;
        while (Math.abs(dot - num) > 0.0001) {
            if (dot > num) {
                r = v;
            } else {
                l = v;
            }
            v = (l + r) / 2;
            dot = v * v;
        }
        return v;
    }

    /**
     * 牛顿迭代法
     * x1 = (x0 + n/x0)/2
     * n是要开根号的数
     * @param num
     * @return
     */
    public float sqrtN(int num) {
        if (num <= 0) {
            return 0.0f;
        }
        float x = num / 2;
        float dot = x * x;
        while (Math.abs(dot - num) > 0.00000000001) {
            x = (x + num / x) / 2;
            dot = x * x;
        }
        return x;
    }

}
