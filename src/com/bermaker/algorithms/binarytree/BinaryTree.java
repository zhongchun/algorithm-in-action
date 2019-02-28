/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public BinaryTree() {

    }

    /**
     * 不输出换行
     *
     * @param root
     */
    public void printLayer(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            list.add(root);
        }
        while (list.size() > 0) {
            TreeNode t = list.get(0);
            System.out.print(t.value() + " ");
            list.remove(0);
            if (t.left() != null) {
                list.add(t.left());
            }
            if (t.right() != null) {
                list.add(t.right());
            }
        }
    }

    /**
     * 输出换行：使用标记的方法
     *
     * @param root
     */
    public void printLayerln(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode mark = new TreeNode('\0');
        if (root != null) {
            list.add(root);
            list.add(mark);
        }
        while (list.size() > 0) {
            TreeNode t = list.get(0);
            if (t.value() == '\0') {
                System.out.println();
                // 最后只剩下一个标记节点时，不再往list中添加标记节点
                if (list.size() > 1) {
                    list.add(mark);
                }
            } else {
                System.out.print(t.value() + " ");
            }
            list.remove(0);
            if (t.left() != null) {
                list.add(t.left());
            }
            if (t.right() != null) {
                list.add(t.right());
            }

        }
    }

    /**
     * 输出换行：使用双队列实现
     *
     * @param root
     */
    public void printLayerlnd(TreeNode root) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        if (root != null) {
            list1.add(root);
        }
        while (list1.size() > 0) {
            for (TreeNode t : list1) {
                System.out.print(t.value() + " ");
                if (t.left() != null) {
                    list2.add(t.left());
                }
                if (t.right() != null) {
                    list2.add(t.right());
                }
            }
            list1.clear();
            System.out.println();
            while (list2.size() > 0) {
                for (TreeNode t : list2) {
                    System.out.print(t.value() + " ");
                    if (t.left() != null) {
                        list1.add(t.left());
                    }
                    if (t.right() != null) {
                        list1.add(t.right());
                    }
                }
                list2.clear();
                System.out.println();
            }
        }
    }

}
