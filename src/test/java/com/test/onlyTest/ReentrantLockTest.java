package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可重入锁
 */
@Slf4j
public class ReentrantLockTest {

    private final Lock lock = new ReentrantLock();
    int value = 0;


    @Test
    public void reentrantLockTest() {
        lock.lock();
        try {
            methodOne();
            methodTwo();
        } finally {
            lock.unlock();
        }
    }

    private void methodOne() {
        lock.lock();
        try {
            log.info("lock methodOne");
        } finally {
            lock.unlock();
        }
    }

    private void methodTwo() {
        try {
            log.info("lock methodTwo");
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void reentrantTest() throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        final Thread thread = new Thread(test::addOne);
        thread.start();
        thread.join();
        log.info("reentrantTest value: {}", test.value);
    }


    public int get() {
        // 获取锁
        lock.lock();
        try {
            return value;
        } finally {
            // 保证锁能释放
            lock.unlock();
        }
    }

    public void addOne() {
        // 获取锁
        lock.lock();
        try {
            value = 1 + get();
        } finally {
            // 保证锁能释放
            lock.unlock();
        }
    }


}
