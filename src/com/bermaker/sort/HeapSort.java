/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.sort;

public class HeapSort {

    private int[] A;

    private int heapSize;

    private HeapSort(int[] A) {
        this.A = A;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && A[l] > A[i]) {
            largest = l;
        }
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        heapSize = A.length;
        for (int i = (A.length / 2 - 1); i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapsort() {
        buildMaxHeap();
        for (int i = A.length - 1; i > 0; i--) {
            int tmp = A[i];
            A[i] = A[0];
            A[0] = tmp;
            heapSize--;
            maxHeapify(0);
        }
    }

    public void print() {
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void main(String[] args) {
        // int[] A = { 3, 8, 6, 14, 2, 1 };
        int[] A = { 13, 8, 5, 7, 6, 14, 2, 1, 19 };
        HeapSort hs = new HeapSort(A);
        hs.heapsort();
        hs.print();
    }
}
