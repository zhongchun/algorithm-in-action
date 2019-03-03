/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: ListMerge
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 7:26 PM
 * @Version: 1.0
 */
public class ListMerge {

    /**
     * 题目：
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
     * <p>
     * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
     * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
     * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
     * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，直到快的走到了末尾，然后
     * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
     * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
     * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
     * <p>
     * 主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    /**
     * 合并两个有序链表：升序
     *
     * @param l
     * @param r
     *
     * @return
     */
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }

    /**
     * 合并两个有序链表：升序
     * 类似归并排序中的合并过程
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode cur = header;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return header.next;
    }

    /**
     * 合并K个有序链表：升序
     * 将k个链表读到list中，再执行list排序，最后从list中依次读取node，建立新链表
     *
     * @param lists
     *
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode header = new ListNode(0);
        ListNode point = header;
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        for (int x : list) {
            point.next = new ListNode(x);
            point = point.next;
        }
        return header.next;
    }

    /**
     * 合并K个有序链表：升序
     * 从k个链表中找出最小的node，放到新建的链表中，并从原链表中删除
     *
     * @param lists
     *
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode header = new ListNode(0);
        ListNode point = header;
        while (true) {
            int min_val = Integer.MAX_VALUE;
            int position = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min_val) {
                        min_val = lists[i].val;
                        position = i;
                    }
                }
            }
            if (min_val == Integer.MAX_VALUE) {
                break;
            }
            point.next = new ListNode(min_val);
            point = point.next;
            lists[position] = lists[position].next;
        }
        return header.next;
    }

}
