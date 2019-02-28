/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test;

import java.util.ArrayList;

import org.junit.Test;

import com.bermaker.algorithms.reverseinteger.ReverseInteger;

public class ReverseIntegerTest {

    @Test
    public void testReverseInteger() {
        int number = 123;
        // int number = -123;
        // int number = 120;
        int absolute = Math.abs(number);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (absolute != 0) {
            // System.out.print(number % 10);
            list.add(absolute % 10);
            absolute /= 10;
        }

        int ret = 0;
        for (Integer num : list) {
            ret = ret * 10 + num;
        }
        if (number < 0) {
            ret *= -1;
        }
        System.out.println(ret);
    }

    @Test
    public void testReverseInteger1() {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = -1230;
        int ret = reverseInteger.reverse0(x);
        System.out.println(x);
        System.out.println(ret);
    }

}
