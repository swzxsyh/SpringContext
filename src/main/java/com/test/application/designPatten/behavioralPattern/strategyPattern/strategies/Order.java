package com.test.application.designPatten.behavioralPattern.strategyPattern.strategies;

/**
 * 订单类
 *
 * @author swzxsyh
 */
public class Order {

    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy) {
        payStrategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = Boolean.TRUE;
    }
}
