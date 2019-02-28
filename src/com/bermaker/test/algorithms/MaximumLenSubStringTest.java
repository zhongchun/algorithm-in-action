/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Test;

import com.bermaker.algorithms.maximumlensubstring.MaximumLenSubString;

/**
 * @ClassName: MaximumLenSubStringTest
 * @Desc: TODO
 * @author: yuzhongchun
 * @date: 2018年9月11日 下午4:33:19
 * 
 */
public class MaximumLenSubStringTest {

    @Test
    public void testSolution() {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aab";
        String s5 = "dvdf";
        String s6 = "tmmzuxt";
        MaximumLenSubString mlss = new MaximumLenSubString();
        int len1 = mlss.lengthOfLongestSubstring(s1);
        int len2 = mlss.lengthOfLongestSubstring(s2);
        int len3 = mlss.lengthOfLongestSubstring(s3);
        int len4 = mlss.lengthOfLongestSubstring(s4);
        int len5 = mlss.lengthOfLongestSubstring(s5);
        int len6 = mlss.lengthOfLongestSubstring(s6);
        System.out.println(len1);
        System.out.println(len2);
        System.out.println(len3);
        System.out.println(len4);
        System.out.println(len5);
        System.out.println(len6);
    }

}
