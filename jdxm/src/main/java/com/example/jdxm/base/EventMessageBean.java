package com.example.jdxm.base;

/**
 * Created by DELL on 2017/12/21.
 */

public class EventMessageBean {
    private int sum;
    private int sumPrice;

    public EventMessageBean(int sum, int sumPrice) {
        this.sum = sum;
        this.sumPrice = sumPrice;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
}
