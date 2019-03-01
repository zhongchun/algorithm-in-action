/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BinaryTreeKmin
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/1 3:19 PM
 * @Version: 1.0
 */
public class BinaryTreeKmin {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res = kthSmallest(root.left, k);
        if (index == k) {
            return res;
        }
        if (++index == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }
}
