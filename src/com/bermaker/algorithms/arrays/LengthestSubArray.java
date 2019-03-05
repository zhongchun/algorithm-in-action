/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.arrays;

/**
 * @ClassName: LengthestSubArray
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/5 10:36 AM
 * @Version: 1.0
 */
public class LengthestSubArray {

    /**
     * 输入：整型数组A，sum (假设A中都是正数)
     * 输出：找出数组中连续子数组，并且其和等于sum，最长的连续子数组的长度
     * A=[3, 2, 1, 5, 8, 7, 1, 5], sum=8
     */
    public int lengthestSubArray(int[] A, int sum) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int length = 0;
        int add = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i;
            while (j < A.length) {
                add += A[j];
                if (add == sum) {
                    if (length < (j - i + 1)) {
                        length = j - i + 1;
                    }
                    i = j + 1;
                    break;
                } else if (add > sum) {
                    add = 0;
                    break;
                } else {
                    j++;
                    if (j >= A.length) {
                        return length;
                    }
                }
            }
        }
        return length;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     *
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    /**
     * @param nums
     *
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        return maxSubSum(nums, 0, nums.length - 1);
    }

    /**
     * 分治
     *
     * @param seq
     * @param left
     * @param right
     *
     * @return
     */
    public int maxSubSum(int[] seq, int left, int right) {
        int maxLeftSum = 0;
        int maxRightSum = 0;
        int leftBorderSum = 0;// 左半边包含最右一位数的和
        int rightBorderSum = 0;// 右半边包含最左一位数的和
        int maxLeftBorderSum = 0;
        int maxRightBorderSum = 0;
        /* 只有一个元素 */
        if (left == right) {
            if (seq[left] > 0) {
                return seq[0];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        maxLeftSum = maxSubSum(seq, left, center);
        maxRightSum = maxSubSum(seq, center + 1, right);
        /* 左半边最大和 */
        for (int i = center; i >= left; i--) {
            leftBorderSum += seq[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        /* 右半边最大和 */
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += seq[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        /* 返回三个值中的最大值 */
        return Math.max(maxLeftBorderSum + maxRightBorderSum, Math.max(maxLeftSum, maxRightSum));
    }

    /**
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    /**
     * 动态规划
     * 考虑到乘积子序列中有正有负也还可能有0，我们可以把问题简化成这样：
     * 数组中找一个子序列，使得它的乘积最大；同时找一个子序列，使得它的乘积最小（负数的情况）。
     * 因为虽然我们只要一个最大积，但由于负数的存在，我们同时找这两个乘积做起来反而方便。
     * 也就是说，不但记录最大乘积，也要记录最小乘积。
     * <p>
     * 假设数组为a[]，直接利用动态规划来求解，考虑到可能存在负数的情况，
     * 我们用maxend来表示以a[i]结尾的最大连续子串的乘积值，
     * 用minend表示以a[i]结尾的最小的子串的乘积值，那么状态转移方程为：
     * <p>
     * maxend = max(max(maxend * a[i], minend * a[i]), a[i]);
     * minend = min(min(maxend * a[i], minend * a[i]), a[i]);
     * <p>
     * 初始状态为 maxend = minend = a[0]。
     *
     * @param nums
     *
     * @return
     */
    public int maxProduct1(int[] nums) {
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int end1 = imax * nums[i];
            int end2 = imin * nums[i];
            imax = Math.max(Math.max(end1, end2), nums[i]);
            imin = Math.min(Math.min(end1, end2), nums[i]);
            max = Math.max(imax, imin);
        }
        return max;
    }
}
