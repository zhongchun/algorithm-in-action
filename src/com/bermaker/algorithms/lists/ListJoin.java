/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.lists;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ListJoin
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/1 12:24 PM
 * @Version: 1.0
 */
public class ListJoin {

    /**
     * 反转链表
     *
     * @param head
     *
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = head;
        ListNode tmp = null;
        while (curNode != null) {
            tmp = curNode;
            curNode = curNode.next;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }
        return dummyHead.next;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 最终为 m 位置的前一点
        ListNode mPre = dummyHead;
        // 最终为 n 位置的后一点
        ListNode nNext;
        // 待反转的两点
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }
        cur = mPre.next;
        next = cur.next;
        nNext = next;
        for (int i = 0; i < n - m; i++) {
            // 进行反转
            nNext = next.next;
            next.next = cur;
            // 移动到下一个反转处
            cur = next;
            next = nNext;
        }
        // 反转完毕，需要将两端与 mPre 和 nNext 连接
        mPre.next.next = nNext;
        mPre.next = cur;
        return dummyHead.next;
    }

    /**
     * 链表中是否有环：哈希表法
     *
     * @param head
     *
     * @return
     */
    public boolean hasCycle0(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 链表中是否有环：双指针法
     *
     * @param head
     *
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode joinNode = null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != null) {
            set.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            if (set.contains(l2)) {
                joinNode = l2;
                break;
            }
            l2 = l2.next;
        }
        return joinNode;
    }

    /**
     * 返回两个链表的起始交点
     * <p>
     * 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     * 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     **/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }

}
