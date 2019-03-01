package com.bermaker.sort;

/**
 * max-heapify: 维护最大堆性质的关键
 * build-max-heap：从无序的输入数据数组中构造一个最大堆
 * heapsort：对一个数组进行原址排序
 */
public class MaxHeap {

    int[] heap;

    int heapsize;

    /**
     * 初始化，传入数组
     */
    public MaxHeap(int[] array) {
        this.heap = array;
        heapsize = heap.length;
    }

    /**
     * 求节点i的父节点
     *
     * @param i
     *
     * @return
     */
    public int heapParent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 求节点i的左子节点
     *
     * @param i
     *
     * @return
     */
    public int heapLeft(int i) {
        return 2 * i + 1;
    }

    /**
     * 求节点i的右子节点
     *
     * @param i
     *
     * @return
     */
    public int heapRight(int i) {
        return 2 * i + 2;
    }

    /**
     * 维护堆的性质, 此时间复杂度为O(log i)
     *
     * @param i
     */
    public void heapMaximize(int i) {
        int l = heapLeft(i);
        int r = heapRight(i);
        int maximum = i;
        if (l < heapsize && heap[l] > heap[i]) {
            maximum = l;
        }
        if (r < heapsize && heap[r] > heap[maximum]) {
            maximum = r;
        }
        if (maximum == i || maximum >= heapsize) {
            return;
        }
        int tmp = heap[i];
        heap[i] = heap[maximum];
        heap[maximum] = tmp;
        heapMaximize(maximum);
    }

    /**
     * 构造最大堆, 必须从下往上构造
     */
    public void buildMaxHeap() {
        for (int i = heapsize / 2; i >= 0; i--) {
            heapMaximize(i);
        }
    }

    /**
     * 堆排序算法实现
     */
    public void heapSort() {
        for (int i = heapsize - 1; i >= 0; i--) {
            int tmp = heap[i];
            heap[i] = heap[0];
            heap[0] = tmp;
            heapsize--;
            heapMaximize(0);
        }
    }

    public static void printHeapTree(int[] heap) {
        for (int i = 1; i < heap.length; i = i * 2) {
            for (int j = i - 1; j < 2 * i - 1 && j < heap.length; j++) {
                System.out.print(heap[j] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeap(int[] heap) {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + "  ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 8, 6, 14, 2, 1};
        MaxHeap heap = new MaxHeap(array);
        System.out.println("执行最大堆化前堆的结构：");
        printHeapTree(heap.heap);
        heap.buildMaxHeap();
        System.out.println("执行最大堆化后堆的结构：");
        printHeapTree(heap.heap);
        heap.heapSort();
        System.out.println("执行堆排序后数组的内容");
        printHeap(heap.heap);
    }

}