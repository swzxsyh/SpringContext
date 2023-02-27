package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class ThreadLocalTest {

    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();
    private static final ExecutorService executorService = new ThreadPoolExecutor(5,
            30,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5 * 2),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    final Map<String, String> map = new HashMap<>();
                    map.put(finalI + "-Key", finalI + "-Value");
                    THREAD_LOCAL.set(map);

                    log.info("THREAD_LOCAL:{}", THREAD_LOCAL.get());
                    // Simulate some processing

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("ThreadLocalTest error:", e);
                } finally {
                    THREAD_LOCAL.remove();
                }

            });
        }
        // Shutdown thread pool after all tasks are completed
        executorService.shutdown();
    }


}
