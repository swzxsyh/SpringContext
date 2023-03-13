package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode179Test {

    @Test
    public void leetCode179Test() {
//        int[] nums = {10, 2};
        int[] nums = {3, 30, 34, 5, 9};

        String result = new LeetCode179().largestNumber(nums);

        log.info("result: {}", result);
    }

}