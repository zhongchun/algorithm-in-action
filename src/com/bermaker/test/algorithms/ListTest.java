/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bermaker.algorithms.lists.DeleteListKNode;
import com.bermaker.algorithms.lists.ListNode;

public class ListTest {

    private ListNode head;

    private DeleteListKNode deleteListKNode;

    @Before
    public void init() {
        head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        deleteListKNode = new DeleteListKNode();
    }

    @Test
    public void testRemoveNthFromEnd(){
        Assert.assertNotNull(head);
        deleteListKNode.printList(head);
        ListNode list = deleteListKNode.removeNthFromEnd(head, 2);
        deleteListKNode.printList(head);
        deleteListKNode.printList(list);
    }

}
