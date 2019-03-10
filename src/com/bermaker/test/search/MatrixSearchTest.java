package com.bermaker.test.search;

import org.junit.Assert;
import org.junit.Test;

import com.bermaker.search.MatrixSearch;

public class MatrixSearchTest {

    private MatrixSearch matrixSearch = new MatrixSearch();

    @Test
    public void testMatrixBasics() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Assert.assertEquals(3, matrix.length);
        Assert.assertEquals(4, matrix[0].length);
    }

    @Test
    public void testSearchMatrix11() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        boolean ret = matrixSearch.searchMatrix11(matrix, 3);
        Assert.assertEquals(true, ret);
        ret = matrixSearch.searchMatrix11(matrix, 13);
        Assert.assertEquals(false, ret);
        int[][] mt = {{1}, {3}};
        ret = matrixSearch.searchMatrix11(mt, 3);
        Assert.assertEquals(true, ret);
    }

    @Test
    public void testSearchMatrix12() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        boolean ret = matrixSearch.searchMatrix12(matrix, 3);
        Assert.assertEquals(true, ret);
        ret = matrixSearch.searchMatrix12(matrix, 13);
        Assert.assertEquals(false, ret);
        int[][] mt = {{1}, {3}};
        ret = matrixSearch.searchMatrix12(mt, 3);
        Assert.assertEquals(true, ret);
    }
}
