package com.test.application.designPatten.behavioralPattern.strategyPattern.strategies;

/**
 * 通用的支付方法接口
 *
 * @author swzxsyh
 */
public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
