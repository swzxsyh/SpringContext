package com.test.application.designPatten.behavioralPattern.strategyPattern.strategies;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用信用卡支付
 *
 * @author swzxsyh
 */
@Slf4j
public class PayByCreditCard implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;


    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            log.info("Paying {} using Credit Card.", paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            log.info("Enter the card number: ");
            String number = READER.readLine();
            log.info("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            log.info("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);

            // Validate credit card number...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
