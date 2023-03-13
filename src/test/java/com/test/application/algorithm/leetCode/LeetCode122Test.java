package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode122Test {

    @Test
    public void leetCode122Test() {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};

        int[] prices = {7, 6, 4, 3, 1};
        int result = new LeetCode122().maxProfit(prices);
        log.info("max profit: {}", result);
    }

}