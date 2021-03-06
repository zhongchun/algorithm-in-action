/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.mathematics;

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
     * 平方根：返回整数
     *
     * @param x
     *
     * @return
     */
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long lo = 0, hi = x;
        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tmp = mid * mid;
            if (x < tmp) {
                hi = mid - 1;
            } else if (x > tmp) {
                lo = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return lo * lo <= x ? (int) lo : (int) lo - 1;
    }

    /**
     * 二分法求解
     *
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
     *
     * @param num
     *
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
