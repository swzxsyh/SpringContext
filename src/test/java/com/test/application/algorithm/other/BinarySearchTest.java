package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BinarySearchTest {

    final int target = 7;
    final int[] array = {1, 2, 4, 5, 8, 10, 99};

    @Test
    public void searchMinTest() {
        int target = 7;
        int[] array = {1, 2, 4, 5, 8, 10, 99};
        int result = new BinarySearch().searchMin(array, target);
        log.info("result: {}", array[result]);
    }

    @Test
    public void searchMaxTest() {
        int target = 7;
        int[] array = {1, 2, 4, 5, 8, 10, 99};
        int result = new BinarySearch().searchMax(array, target);
        log.info("result: {}", array[result]);
    }
}