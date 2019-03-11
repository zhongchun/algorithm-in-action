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

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 线性查找，时间复杂度 O(n)
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        // 不考虑数组数null和数组为空的情况
        int i = 0;
        //        for (; i < nums.length; i++) {
        //            if (target <= nums[i]) {
        //                return i;
        //            }
        //        }
        while (i < nums.length) {
            if (target <= nums[i]) {
                return i;
            }
            i++;
        }
        return i;
    }

    /**
     * 二分查找，时间复杂度 O(logn)
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int pos = 0;
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;
        while (l <= r) {
            if (nums[m] < target) {
                l = m + 1;
                m = (l + r) / 2;
            } else if (nums[m] > target) {
                r = m - 1;
                m = (l + r) / 2;
            } else {
                pos = m;
                break;
            }
        }
        if (l > r) {
            pos = l;
        }
        return pos;
    }

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     *
     * @return
     */
    public int mySqrt(int x) {
        int sqrt = 0;
        float l = 0;
        float r = x;



        return sqrt;
    }

}
