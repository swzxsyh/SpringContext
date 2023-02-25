package com.test.application.designPatten.behavioralPattern.strategyPattern;

import com.test.application.designPatten.behavioralPattern.strategyPattern.strategies.Order;
import com.test.application.designPatten.behavioralPattern.strategyPattern.strategies.PayByCreditCard;
import com.test.application.designPatten.behavioralPattern.strategyPattern.strategies.PayByPayPal;
import com.test.application.designPatten.behavioralPattern.strategyPattern.strategies.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 客户端代码
 *
 * @author swzxsyh
 */
@Slf4j
public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                log.info("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                log.info("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                log.info("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while ("Y".equalsIgnoreCase(continueChoice));

            if (strategy == null) {
                log.info("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (Objects.equals(paymentMethod, "1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy);

            log.info("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if ("P".equalsIgnoreCase(proceed)) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    log.info("Payment has been successful.");
                } else {
                    log.info("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}