/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.palindromenumber;

/**
 * @Title: PalindromeNumber
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2018/10/12 3:12 PM
 * @Version: 1.0
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int reverse = 0;
        while (tmp != 0) {
            int pop = tmp % 10;
            tmp /= 10;
            reverse = reverse * 10 + pop;
        }
        if (reverse == x) {
            return true;
        } else {
            return false;
        }
    }

}
