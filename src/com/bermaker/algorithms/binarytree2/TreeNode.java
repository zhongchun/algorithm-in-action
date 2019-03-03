/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.binarytree2;

/**
 * @ClassName: TreeNode
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 11:42 AM
 * @Version: 1.0
 */
public class TreeNode<T> {

    private T value;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Gets the value of value
     *
     * @return the value of value
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value
     * <p>You can use getValue() to get the value of value</p>
     *
     * @param value value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Gets the value of left
     *
     * @return the value of left
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left
     * <p>You can use getLeft() to get the value of left</p>
     *
     * @param left left
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Gets the value of right
     *
     * @return the value of right
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right
     * <p>You can use getRight() to get the value of right</p>
     *
     * @param right right
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
