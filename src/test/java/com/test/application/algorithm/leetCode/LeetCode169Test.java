package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode169Test {

    @Test
    public void leetCode169Test() {
        int[] nums = {3, 2, 3};
//        int[] nums = {2,2,1,1,1,2,2};
        int result = new LeetCode169().majorityElement(nums);
        log.info("result: {}", result);
    }
}