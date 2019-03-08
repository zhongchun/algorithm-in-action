/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.search;

/**
 * @ClassName: BinarySearch
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/8 10:44 AM
 * @Version: 1.0
 */
public class BinarySearch {

    /**
     * 查找有序（升序）数组 nums 中数字 target 的位置，即其下标，如果不存在则返回-1
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int binarySearchNum(int[] nums, int target) {
        int pos = -1;
        if (nums == null || nums.length < 1) {
            return pos;
        }
        int l = 0;
        int r = nums.length - 1;
        // l + r 有可能会溢出，除以 2 的结果也可能溢出，此处暂不考虑
        int m = (l + r) / 2;
        while (l <= r) {
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
                m = (l + r) / 2;
            } else {
                l = m + 1;
                m = (l + r) / 2;
            }
        }
        return pos;
    }

    /**
     * 查找有序（升序）数组 nums 中比 target 小的最大的那个数的位置，即下标
     * 如果没有比 target 小的数，则返回 -1
     * 注：不存在重复数字，数字大小不超过100000，数组长度不超过10000
     * 比如：
     * 输入：
     * nums = {-3, 1, 8, 9, 13, 20, 38, 103}
     * target = 35
     * 输出：
     * 5
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int findFisrtLessNum(int[] nums, int target) {
        int pos = -1;
        if (nums == null || nums.length < 1) {
            return pos;
        }
        int l = 0;
        int r = nums.length;
        int m = (l + r) / 2;
        // m, m+1
        while (l <= r) {
            if (m == nums.length - 1) {
                if (nums[m] < target) {
                    return m;
                } else {
                    return -1;
                }
            } else {
                if (nums[m] < target && nums[m + 1] >= target) {
                    return m;
                } else if (nums[m] >= target) {
                    r = m;
                    m = (l + r) / 2;
                } else {
                    l = m + 1;
                    m = (l + r) / 2;
                }
            }
        }
        return pos;
    }

}
