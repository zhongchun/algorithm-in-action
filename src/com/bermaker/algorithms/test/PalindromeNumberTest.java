/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.test;

import com.bermaker.algorithms.palindromenumber.PalindromeNumber;
import org.junit.Test;

/**
 * @Title: PalindromeNumberTest
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2018/10/12 3:18 PM
 * @Version: 1.0
 */
public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() {
        int x = -121;
        PalindromeNumber pn = new PalindromeNumber();
        boolean ret = pn.isPalindrome(x);
        System.out.println(ret);
    }
}
