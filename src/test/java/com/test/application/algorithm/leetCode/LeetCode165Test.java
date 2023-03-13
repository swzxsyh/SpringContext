package com.test.application.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCode165Test {

    @Test
    public void leetCode165Test() {
        String version1 = "1.01", version2 = "1.001";
//        String version1 = "1.0", version2 = "1.0.0";
//        String version1 = "0.1", version2 = "1.1";
//        String version1 = "1", version2 = "1.0";
//        String version1 = "1.05", version2 = "1.1";
        int result = new LeetCode165().compareVersion(version1, version2);
        log.info("result: {}", result);
    }
}