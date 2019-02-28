/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test;

import org.junit.Before;
import org.junit.Test;

import com.bermaker.algorithms.BinaryTree;
import com.bermaker.algorithms.TreeNode;

/**
 * @ClassName: BinaryTreeTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 11:59 AM
 * @Version: 1.0
 */
public class BinaryTreeTest {

    private BinaryTree<Character> binaryTree;

    private TreeNode<Character> root;

    @Before
    public void constructBinaryTree() {
        binaryTree = new BinaryTree<>();
        root = new TreeNode<>('A');
        TreeNode<Character> t1 = new TreeNode<>('B');
        TreeNode<Character> t2 = new TreeNode<>('C');
        TreeNode<Character> t3 = new TreeNode<>('D');
        TreeNode<Character> t4 = new TreeNode<>('E');
        TreeNode<Character> t5 = new TreeNode<>('F');
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t1.setRight(t4);
        t3.setLeft(t5);
    }

    @Test
    public void testPreOrder() {
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.preOrderStack(root);
    }

    @Test
    public void testInOrder() {
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.inOrderStack(root);
    }

    @Test
    public void testPostOrder() {
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.postOrderStack(root);
    }

}
