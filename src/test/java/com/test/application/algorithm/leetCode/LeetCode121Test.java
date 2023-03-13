package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode121Test {

    int[] prices = {7, 6, 4, 3, 1};
//    int[] prices = {7, 1, 5, 3, 6, 4};

    @Test
    public void leetCode121Test() {
        LeetCode121 leetCode = new LeetCode121();
        int result = leetCode.maxProfit(prices);
        log.info("last price: {}", result);
    }
}