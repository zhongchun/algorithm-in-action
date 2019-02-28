/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.binarytree;

public class TreeNode {
    private char value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public char value() {
        return value;
    }

    public TreeNode left() {
        return left;
    }

    public TreeNode right() {
        return right;
    }

    public void setValue(char ch) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
