package com.test.application.designPatten.behavioralPattern.strategyPattern.strategies;

/**
 * 信用卡类
 *
 * @author swzxsyh
 */
public class CreditCard {

    private int amount;
    private String number;
    private String date;
    private String cvv;

    public CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
