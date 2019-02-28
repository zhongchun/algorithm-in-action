/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.algorithms;

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
