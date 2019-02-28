/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms;

/**
 * @ClassName: Palindrome
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 10:35 AM
 * @Version: 1.0
 */
public class Palindrome {

    /**
     * 判断是否是回文数
     *
     * @param str
     *
     * @return
     */
    public boolean isPn(char[] str) {
        if (str == null) {
            return false;
        }
        int half = str.length / 2;
        for (int i = 0; i < half; i++) {
            if (str[i] != str[str.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最小切分数
     *
     * @param s
     *
     * @return
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        // dp[i]存放(0,i)即以i的字符结束的子串的最小切割数，则所求为dp[s.length()-1];
        dp[0] = 0; //一个字符，不需要切割
        for (int i = 1; i < s.length(); i++) {
            // dp[i]赋初值
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            //  1=<j<=i的子串回文判定
            for (int j = i; j >= 1; j--) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }

    /**
     * 判断是否是回文数
     *
     * @param s
     *
     * @return
     */
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 方案：中心扩展法
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}