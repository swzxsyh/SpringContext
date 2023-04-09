package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TournamentSearchTest {

    @Test
    public void getLightestBall() {
        int[] arrays = {3, 2, 4, 5, 7, 1, 11, 9, 8};
        int lightestBall = new TournamentSearch().getLightestBall(arrays);
        log.info("result: {}", lightestBall);
    }
}