package com.bermaker.search;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: MatrixSearch
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/10 16:423 PM
 * @Version: 1.0
 */
public class MatrixSearch {

    /**
     * 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     *
     * @param matrix
     * @param target
     *
     * @return
     */
    public boolean searchMatrix11(int[][] matrix, int target) {
        // 二分查找，总共是 m * n 个数字，可以把二维当成是一位数组来做二分查找
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int amount = rowNum * colNum;
        int l = 0;
        int r = amount - 1;
        int m = (l + r) / 2;
        int row = 0;
        int col = 0;
        int tmp = 0;
        while (l <= r) {
            // 关键点：row 和 col 的计算
            row = m / colNum;
            col = m % colNum;
            tmp = matrix[row][col];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                r = m - 1;
                m = (l + r) / 2;
            } else {
                l = m + 1;
                m = (l + r) / 2;
            }
        }
        return false;
    }

    /**
     * @param matrix
     * @param target
     *
     * @return
     */
    public boolean searchMatrix12(int[][] matrix, int target) {
        // 先定位行，再定位列
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int rowL = 0;
        int rowH = rowNum - 1;
        int m = (rowL + rowH) / 2;
        int rowP = 0;
        while (rowL <= rowH) {
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] < target) {
                rowL = m + 1;
                m = (rowL + rowH) / 2;
            } else {
                rowH = m - 1;
                m = (rowL + rowH) / 2;
            }
        }
        rowP = Math.max(rowL - 1, 0);
        int colL = 0;
        int colR = colNum - 1;
        m = (colL + colR) / 2;
        while (colL <= colR) {
            if (matrix[rowP][m] == target) {
                return true;
            } else if (matrix[rowP][m] < target) {
                colL = m + 1;
                m = (colL + colR) / 2;
            } else {
                colR = m - 1;
                m = (colL + colR) / 2;
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵2
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 20，返回 false。
     *
     * @param matrix
     * @param target
     *
     * @return
     */
    public boolean searchMatrix21(int[][] matrix, int target) {
        // 利用hash表，时间复杂度是O(mn)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                set.add(matrix[i][j]);
            }
        }
        if (set.contains(target)) {
            return true;
        }
        return false;
    }

    /**
     * @param matrix
     * @param target
     *
     * @return
     */
    public boolean searchMatrix22(int[][] matrix, int target) {
        // 减少查询的范围：从右上角开始比较 时间复杂度：O(m+n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int row = 0;
        int col = colNum - 1;
        while (row < rowNum && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
