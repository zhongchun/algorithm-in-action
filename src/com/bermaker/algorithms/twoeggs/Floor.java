/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.twoeggs;

/**
 * @ClassName: Floor
 * @Project: duhub-data-statistics
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/1/25 11:01 AM
 * @Version: 1.0
 */
public class Floor {

    /**
     * 100 层楼，扔 2 个鸡蛋，找出刚好鸡蛋碎的楼层所用的最少次数
     *
     * @param ceil
     *
     * @return
     */
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

    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * <p>
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * <p>
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * <p>
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * <p>
     * 你的目标是确切地知道 F 的值是多少。
     * <p>
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     * <p>
     * 动态规划
     * dp[k][m] 的含义是 k 个鸡蛋 移动 m 次最多能够确定多少楼层
     * 这个角度思考
     * dp[k][m] 最多能够确定的楼层数为L
     * 那么我选定第一个扔的楼层之后，要么碎，要么不碎
     * 这就是把 L 分成3段
     * 左边是碎的那段 长度是dp[k][m - 1]
     * 右边是没碎的那段 长度是dp[k-1][m - 1] 因为已经碎了一个了
     * 中间是我选定扔的楼层 是1
     * 所以递推公式是
     * dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1
     *
     * @param K: egg number
     * @param N: floor number
     *
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }

    public static void main(String[] args) {
        Floor floor = new Floor();
        int ceil = 200;
        int num = floor.leastNumber(ceil);
        System.out.println("num=" + num);

    }

}

