package com.bermaker.algorithms.maximumsubarray;

public class MaximumSubArray {

    /**
     * @Title: findMaxSubArray
     * @Desc: recursive algorithm to find maximum sub array 
     * @param A
     * @param low
     * @param high
     * @return
     */
    public MsaRet findMaxSubArray(int[] A, int low, int high) {
        if (low == high) {
            return new MsaRet(low, high, A[low]);
        } else {
            int mid = (low + high) / 2;
            MsaRet leftRet = findMaxSubArray(A, low, mid);
            MsaRet rightRet = findMaxSubArray(A, mid + 1, high);
            MsaRet crossRet = findMaxCrossSubAarry(A, low, mid, high);
            if (leftRet.getSum() >= rightRet.getSum() && leftRet.getSum() >= crossRet.getSum()) {
                return leftRet;
            } else if (rightRet.getSum() >= leftRet.getSum() && rightRet.getSum() >= crossRet.getSum()) {
                return rightRet;
            } else {
                return crossRet;
            }
        }
    }

    /**
     * @Title: findMaxCrossSubAarry
     * @Desc: find max crossing sub array
     * @param A
     * @param low
     * @param mid
     * @param high
     * @return
     */
    public MsaRet findMaxCrossSubAarry(int[] A, int low, int mid, int high) {
        MsaRet ret = new MsaRet();
        int maxLeft = low;
        int maxRight = high;
        // left
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        // right
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        ret.setLow(maxLeft);
        ret.setHigh(maxRight);
        ret.setSum(leftSum + rightSum);
        return ret;
    }

}
