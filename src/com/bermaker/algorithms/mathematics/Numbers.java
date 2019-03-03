package com.bermaker.algorithms.mathematics;

import java.util.HashMap;

public class Numbers {

    /**
     * 只出现一次的数字
     *
     * @param nums
     *
     * @return
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret = ret ^ n;
        }
        return ret;
    }

    /**
     * 求众数
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            if (hashMap.containsKey(n)) {
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }
        int majority = nums[0];
        int max = 1;
        for (int n : nums) {
            if (max < hashMap.get(n)) {
                max = hashMap.get(n);
                majority = n;
            }
        }
        return majority;
    }

    /**
     * 摩尔投票法 Moore Voting
     * 先将第一个数字假设为众数，然后把计数器设为1，
     * 比较下一个数和此数是否相等，若相等则计数器加一，反之减一。
     * 然后看此时计数器的值，若为零，则将下一个值设为候选众数。
     * 以此类推直到遍历完整个数组，当前候选众数即为该数组的众数。
     * 前提：数组中一定要有众数的存在才能使用
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement1(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }

    /**
     * 位操作
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement2(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    ++ones;
                } else {
                    ++zeros;
                }
            }
            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }

}
