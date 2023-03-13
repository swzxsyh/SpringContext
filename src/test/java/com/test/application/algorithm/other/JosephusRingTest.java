package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JosephusRingTest {

    @Test
    public void ringTest() {
        int n = 10, firstNumber = 2;
        final int solution = new JosephusRing().solution(n, firstNumber);
        log.info("result: {}", solution);
    }
}