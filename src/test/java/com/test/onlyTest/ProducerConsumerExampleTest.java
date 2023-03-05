package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者测试
 */
@Slf4j
public class ProducerConsumerExampleTest {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5 * 2), new ThreadPoolExecutor.CallerRunsPolicy());

    // 缓冲区大小
    final int capacity = 5;
    // 缓冲区
    LinkedList<Integer> buffer = new LinkedList<>();


    public static void main(String[] args) {
        //生产者线程
        executorService.execute(()->new ProducerConsumerExampleTest().publish());
        // 消费者线程
        executorService.execute(()->new ProducerConsumerExampleTest().subscribe());
    }

    private void publish() {
        int value = 0;
        while (true) {
            synchronized (buffer) {
                while (buffer.size() == capacity) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //生产数据并加入缓冲区
                buffer.add(value++);
                log.info("生产者生产了：{}", value);
                //通知消费者消费
                buffer.notifyAll();
            }
        }
    }

    private void subscribe() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 从缓冲区中取出数据并消费
                int value = buffer.remove();
                log.info("生产者消费了：{}", value);

                //通知生产者生产
                buffer.notifyAll();
            }
        }
    }

}
