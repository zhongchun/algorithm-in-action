/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms;

import java.util.LinkedList;

/**
 * @ClassName: BinaryTree
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 11:54 AM
 * @Version: 1.0
 */
public class BinaryTree<T> {

    /**
     * DFS之前序遍历，递归实现
     *
     * @param root
     */
    public void preOrder(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * DFS之前序遍历，非递归实现
     *
     * @param root
     */
    public void preOrderStack(TreeNode<T> root) {
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode<T> first = stack.pop();
                System.out.print(first.getValue() + " ");
                if (first.getRight() != null) {
                    stack.push(first.getRight());
                }
                if (first.getLeft() != null) {
                    stack.push(first.getLeft());
                }
            }
        }
    }

    /**
     * DFS之中序遍历，递归实现
     *
     * @param root
     */
    public void inOrder(TreeNode<T> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }

    /**
     * DFS之中序遍历，非递归实现
     *
     * @param root
     */
    public void inOrderStack(TreeNode<T> root) {
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (true) {
                TreeNode<T> first = stack.pop();
                if (first.getRight() != null) {
                    stack.push(first.getRight());
                }
                stack.push(first);
                if (first.getLeft() != null) {
                    stack.push(first.getLeft());
                }
                if (first.getLeft() == null && first.getRight() == null) {
                    break;
                }
            }
            while (!stack.isEmpty()) {
                TreeNode<T> tmp = stack.pop();
                System.out.print(tmp.getValue() + " ");
            }
        }
    }

    /**
     * DFS之后序遍历，递归实现
     *
     * @param root
     */
    public void postOrder(TreeNode<T> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    /**
     * DFS之后序遍历，非递归实现
     *
     * @param root
     */
    public void postOrderStack(TreeNode<T> root) {
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (true) {
                TreeNode<T> first = stack.pop();
                stack.push(first);
                if (first.getRight() != null) {
                    stack.push(first.getRight());
                }
                if (first.getLeft() != null) {
                    stack.push(first.getLeft());
                }
                if (first.getLeft() == null && first.getRight() == null) {
                    break;
                }
            }
            while (!stack.isEmpty()) {
                TreeNode<T> tmp = stack.pop();
                System.out.print(tmp.getValue() + " ");
            }
        }
    }

}
