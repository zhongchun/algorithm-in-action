/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class DeleteListKNode {

    /**
     * 两次遍历
     *
     * @param head
     * @param n
     *
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (n < 1 || n > length) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        cur = head;
        int count = 0;
        int order = length - n + 1;
        while (cur != null) {
            count++;
            if (count != order) {
                list.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode(0);
        cur = dummyHead;
        for (Integer val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
    }

    /**
     * 一次遍历
     *
     * @param head
     * @param n
     *
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 1; i <= n + 1; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
