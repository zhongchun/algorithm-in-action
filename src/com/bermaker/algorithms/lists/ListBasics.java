/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @ClassName: ListBasics
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/1 12:24 PM
 * @Version: 1.0
 */
public class ListBasics {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * <p>
     * <p>
     * 说明:
     * <p>
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 反转链表：包含头节点，往头结点后面插入节点
     *
     * @param head
     *
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = head;
        ListNode next = null;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = dummyHead.next;
            dummyHead.next = curNode;
            curNode = next;
        }
        return dummyHead.next;
    }

    /**
     * 反转链表：无头节点，逐步调整指针
     *
     * @param head
     *
     * @return
     */
    public ListNode reveseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 反转从位置 m 到 n 的链表
     *
     * @param head
     * @param m
     * @param n
     *
     * @return
     */
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode mPre = dummyHead;
        ListNode nNext = null;
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }
        cur = mPre.next;
        next = cur.next;
        nNext = next;
        for (int i = 0; i < n - m; i++) {
            nNext = next.next;
            next.next = cur;
            cur = next;
            next = nNext;
        }
        mPre.next.next = nNext;
        mPre.next = cur;
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
     * 链表中是否有环：快慢指针
     *
     * @param head
     *
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * 说明：不允许修改给定的链表。
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     *
     * @param head
     *
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodesSeen.contains(cur)) {
                return cur;
            } else {
                nodesSeen.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 解题思路：
     * 快慢指针同时从起点节点开始，快指针每次走两步，慢指针每次走一步，有环必相遇；
     * 相遇后慢指针单步走，快指针从头单步走，再次相遇点为环起始点
     * <p>
     * 分两个步骤:
     * 首先通过快慢指针的方法判断链表是否有环；
     * 接下来如果有环，则寻找入环的第一个节点。
     * 具体的方法为:
     * 首先假定链表起点到入环的第一个节点A的长度为a【未知】，
     * 到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】
     * 现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，
     * 所以慢指针p从B继续走（a + b）又能回到B点，如果只走a个长度就能回到节点A。
     * 但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，
     * 那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p
     * 同步走，相遇的地方必然是入环的第一个节点A。 文字有点绕，画个图就一目了然了~~
     *
     * @param head
     *
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode p = head;
        ListNode p2 = head;
        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }
        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return q;
        } else {
            return null;
        }
    }

    /**
     * 返回两个链表的起始交点
     *
     * @param headA
     * @param headB
     *
     * @return
     */
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
