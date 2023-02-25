package com.test;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

public class CompareAtomicAdderTest {

    private final ExecutorService executor = Executors.newFixedThreadPool(16);
    static final int PARK_TIME = 2000000000;

    @Test
    public void atomicLongTest() {
        AtomicLong counter = new AtomicLong(0);
        for (int i = 0; i < 100; i++) {
            executor.submit(new AtomicLongTask(counter));
        }

        LockSupport.parkNanos(PARK_TIME);
        System.out.println(counter.get());
    }

    @Test
    public void longAdderTest() {
        LongAdder counter = new LongAdder();
        for (int i = 0; i < 100; i++) {
            executor.submit(new LongAdderTest(counter));
        }

        LockSupport.parkNanos(PARK_TIME);
        System.out.println(counter.sum());
    }


    static class AtomicLongTask implements Runnable {

        private final AtomicLong counter;

        AtomicLongTask(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }

    static class LongAdderTest implements Runnable {

        private final LongAdder counter;

        LongAdderTest(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }


}
