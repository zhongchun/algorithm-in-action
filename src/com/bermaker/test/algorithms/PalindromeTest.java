/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Test;

import com.bermaker.algorithms.Palindrome;

/**
 * @ClassName: PalindromeTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 10:38 AM
 * @Version: 1.0
 */
public class PalindromeTest {

    private Palindrome palindrome = new Palindrome();

    @Test
    public void testIsPn() {
        String str = new String("abcabc");
        boolean flag = palindrome.isPn(str.toCharArray());
        System.out.println(flag);
    }

    @Test
    public void testMinCut() {
        String str = "cdeba";
        int cutNumber = palindrome.minCut(str);
        System.out.println(cutNumber);
    }

    @Test
    public void testLongestPalindrome() {
        String s = "babad";
        String ps = palindrome.longestPalindrome(s);
        System.out.println(ps);
    }
}
