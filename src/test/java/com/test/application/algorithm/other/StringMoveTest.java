package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StringMoveTest {

    @Test
    public void stringMoveTest(){
        String str = "abc**gh*58*r";
        String result = new StringMove().sortOrder(str);
        log.info("result: {}", result);
    }
}