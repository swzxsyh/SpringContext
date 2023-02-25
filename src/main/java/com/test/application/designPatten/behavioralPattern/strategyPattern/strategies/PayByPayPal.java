package com.test.application.designPatten.behavioralPattern.strategyPattern.strategies;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用 PayPal 支付
 *
 * @author swzxsyh
 */
@Slf4j
public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            log.info("Paying {} using PayPal.", paymentAmount);

            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try {

            while (!signedIn) {
                log.info("Enter the user's email: ");
                email = READER.readLine();
                log.info("Enter the password: ");
                password = READER.readLine();
                if (verify()) {
                    log.info("Data verification has been successful.");
                } else {
                    log.info("Wrong email or password!");
                }
            }
        } catch (IOException e) {
            log.error("collectPaymentDetails err:", e);
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
