/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.test;

import com.bermaker.algorithms.binarytree.BinaryTree;
import com.bermaker.algorithms.binarytree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

public class BinaryTreeTest {

    private BinaryTree bt = new BinaryTree();

    private LinkedList<Integer> linkedList = new LinkedList<>();

    /**
     * Tree like this;
     *          A
     *       B     C
     *     D  E  F  G
     *   H  I   J    K
     */
    @Test
    public void testPrintLayer() {
        TreeNode root = new TreeNode('A');
        TreeNode t1 = new TreeNode('B');
        TreeNode t2 = new TreeNode('C');
        TreeNode t3 = new TreeNode('D');
        TreeNode t4 = new TreeNode('E');
        TreeNode t5 = new TreeNode('F');
        TreeNode t6 = new TreeNode('G');
        TreeNode t7 = new TreeNode('H');
        TreeNode t8 = new TreeNode('I');
        TreeNode t9 = new TreeNode('J');
        TreeNode t10 = new TreeNode('K');
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t1.setRight(t4);
        t2.setLeft(t5);
        t2.setRight(t6);
        t3.setLeft(t7);
        t3.setRight(t8);
        t5.setLeft(t9);
        t6.setRight(t10);

        bt.printLayer(root);
        System.out.println();
        bt.printLayerln(root);
        System.out.println();
        bt.printLayerlnd(root);
    }

}
