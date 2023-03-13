package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode575Test {

    @Test
    public void leetCode575Test() {
//        int[] candyType = {1, 1, 2, 2, 3, 3};
//        int[] candyType = {1, 1, 2, 3};
        int[] candyType = {6, 6, 6, 6};

        int result = new LeetCode575().distributeCandies(candyType);
        log.info("result: {}", result);
    }
}