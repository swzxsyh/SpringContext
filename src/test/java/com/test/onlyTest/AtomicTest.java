package com.test.onlyTest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    /**
     * CompareAndSet() Test
     */
    @Test
    public void compareAndSetTest() {
        AtomicInteger counter = new AtomicInteger(0);
        int i = 0;
        while (true) {
            int oldValue = counter.get();
            int newValue = oldValue++;
            if (counter.compareAndSet(oldValue, newValue)) {
                break;
            }
            i++;
            System.out.println("current i:" + i);
            if (i == 15) {
                break;
            }
        }
    }
}
