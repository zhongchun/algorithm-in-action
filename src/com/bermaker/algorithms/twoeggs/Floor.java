/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.twoeggs;

/**
 * 100 层楼，扔两个鸡蛋，找出刚好鸡蛋碎的楼层所用的最少次数
 *
 * @ClassName: Floor
 * @Project: duhub-data-statistics
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/1/25 11:01 AM
 * @Version: 1.0
 */
public class Floor {

    public int leastNumber(int ceil) {
        int[] floors = new int[ceil + 1];
        floors[1] = 1;
        floors[2] = 2;
        for (int i = 3; i < ceil + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int tmp = Math.max(j, 1 + floors[i - j]);
                if (min > tmp) {
                    min = tmp;
                }
            }
            floors[i] = min;
        }
        return floors[ceil];
    }

    public static void main(String[] args) {
        Floor floor = new Floor();
        int ceil = 200;
        int num = floor.leastNumber(ceil);
        System.out.println("num=" + num);

    }

}

