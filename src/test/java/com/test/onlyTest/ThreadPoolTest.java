package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 线程池顺序/乱序测试 && 变量设置final原因
 */
@Slf4j
public class ThreadPoolTest {

    private static final ExecutorService executorService = new ThreadPoolExecutor(5,
            30,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5 * 2),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 顺序执行
     * <p>
     * ThreadPool按照for循环顺序一个个将任务扔进线程池，每一个任务需要一个线程执行，因此ThreadPool根据线程可用性依次执行这些任务
     */
    @Test
    public void threadPoolOrderTest() {
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i:" + i);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 乱序执行
     * <p>
     * 在for循环内部调用线程池，线程执行顺序是无序的，ThreadPool内部维护一个线程池，线程池是可以异步执行的，会根据可用性和任务的优先等级因素决定任务顺序。
     * <p>
     * ThreadPool执行是异步的，可能在其执行时外部变量可能发生变化，为保证内部任务使用跟外部一致，需要将其设置为final，防止其被修改
     */
    @Test
    public void threadPoolOutOfOrderTest() {
        for (int o = 0; o < 10; o++) {
            final int finalO = o;
            executorService.submit(() -> {
                System.out.println("o:" + finalO);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
