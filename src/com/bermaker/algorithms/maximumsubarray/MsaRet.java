package com.bermaker.algorithms.maximumsubarray;

public class MsaRet {

    private int low;

    private int high;

    private int sum;

    /**
     * @Title: MsaRet
     * @Desc: TODO
     */
    public MsaRet() {
    }

    /**
     * @Title: MsaRet
     * @Desc: TODO
     * @param low
     * @param high
     * @param sum
     */
    public MsaRet(int low, int high, int sum) {
        this.low = low;
        this.high = high;
        this.sum = sum;
    }

    /**
     * @return the low
     */
    public int getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(int low) {
        this.low = low;
    }

    /**
     * @return the high
     */
    public int getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(int high) {
        this.high = high;
    }

    /**
     * @return the sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(int sum) {
        this.sum = sum;
    }



}
