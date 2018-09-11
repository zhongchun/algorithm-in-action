package com.bermaker.algorithms.test;

import org.junit.Test;

import com.bermaker.algorithms.median.MedianOf2SortedArray;

public class MedianOf2SortedArrayTest {

    @Test
    public void testMedia() {
        MedianOf2SortedArray msa = new MedianOf2SortedArray();
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        double median = msa.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

    }

}
