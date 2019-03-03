/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Test;

import com.bermaker.algorithms.mathematics.Sqrt;

/**
 * @ClassName: SqrtTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/27 5:06 PM
 * @Version: 1.0
 */
public class SqrtTest {

    private Sqrt s = new Sqrt();

    @Test
    public void testSqrt() {
        int num = 3000;
        float v = s.sqrt0(num);
        double vt = Math.sqrt(num);
        System.out.println(v);
        System.out.println(vt);
    }

    @Test
    public void testSqrtN() {
        int num = 3000;
        float v = s.sqrtN(num);
        double vt = Math.sqrt(num);
        System.out.println(v);
        System.out.println(vt);
    }

}
