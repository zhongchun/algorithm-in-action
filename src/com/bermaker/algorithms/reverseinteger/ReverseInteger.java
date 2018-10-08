/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.reverseinteger;

import java.util.ArrayList;

/**
 * @desc:
 * @author:
 */
public class ReverseInteger {

    /**
     * @param x
     * @return
     */
    public int reverse(int x) {
        int absolute = Math.abs(x);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (absolute != 0) {
            // System.out.print(number % 10);
            list.add(absolute % 10);
            absolute /= 10;
        }

        long ret = 0;
        for (Integer num : list) {
            ret = ret * 10 + num;
        }
        if (x < 0) {
            ret *= -1;
        }
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) ret;
        }
    }

    /**
     * @param x
     * @return
     */
    public int reverse0(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ret = ret * 10 + pop;
        }
        return ret;
    }

}
