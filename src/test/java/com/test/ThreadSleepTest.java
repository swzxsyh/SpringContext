package com.test;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSleepTest {


    @Test
    public void sleepTest() throws InterruptedException {
        Thread sleepThread = new Thread(() -> {
            System.out.println("SLEEP-THREAD-START");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SLEEP-THREAD-END: " + Thread.currentThread().isInterrupted());
        });
        sleepThread.start();
        Thread.sleep(2000);
        sleepThread.interrupt();
        System.out.println("SLEEP-TEST-END");

    }

    @Test
    public void waitTest() throws InterruptedException {
        Object waitObject = new Object();


        Thread waitThread = new Thread(() -> {
            System.out.println("OBJECT-WAIT-START");
            try {
                //需要先上锁，否则抛出IllegalMonitorStateException异常
                //调用后会释放锁
                synchronized (waitObject) {
                    waitObject.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("OBJECT-WAIT-END: " + Thread.currentThread().isInterrupted());
        });

        waitThread.start();
        Thread.sleep(2000);
        //如果当前线程不是对象锁的持有者，该方法抛出一个IllegalMonitorStateException异常。
        synchronized (waitObject) {
            waitObject.notify();
        }
        System.out.println("OBJECT-TEST-END");
    }

    @Test
    public void parkTest() throws InterruptedException {
        Thread parkThread = new Thread(() -> {
            System.out.println("PARK-THREAD-TEST-START");
            LockSupport.park();
            System.out.println("PARK-THREAD-TEST-END: " + Thread.currentThread().isInterrupted());
        }, "PARK-THREAD");

        LockSupport.unpark(parkThread);
        parkThread.start();
        Thread.sleep(2000);
//        parkThread.interrupt();
        System.out.println("parkTest END");
    }


    @Test
    public void conditionTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        Thread conditionThread = new Thread(() -> {
            System.out.println("CONDITION-THREAD-START");
            lock.lock();

            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            System.out.println("CONDITION-THREAD-END: " + Thread.currentThread().isInterrupted());
        });
        conditionThread.start();
        Thread.sleep(2000);
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }
        System.out.println("CONDITION-TEST-END");
    }
}
