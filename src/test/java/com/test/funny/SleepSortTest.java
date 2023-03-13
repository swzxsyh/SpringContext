package com.test.funny;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 睡眠排序--劣化桶排序
 */
@Slf4j
public class SleepSortTest {
    final int[] nums = {1, 2, 34, 4, 45, 56};
    final ExecutorService executor = new ThreadPoolExecutor(nums.length, nums.length, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Test
    public void sleepSortTest() {
        int[] result = sort(nums);
        log.info("result: {}", result);
    }


    /**
     * 线程池调用方法
     * 坑1：使用fori方式，result[i]永远跟source[i]相同，需使用额外变量，使用普通List方式可以达到效果但需转换回数组，或者如下Atomic类方式
     * 坑2：线程池不能直接while，需要外面套一层
     * <p>
     * 使用"while (executor.isTerminated())"的方式会在线程池还没有完全执行完毕的情况下就关闭了线程池，
     * 这样可能会造成一些任务没有被执行，或者在执行过程中被强制中断，不利于任务的执行。
     * 而使用"while (true) {if (executor.isTerminated()) {break;}}"的方式可以保证线程池中的任务被完全执行完毕后再关闭线程池，确保任务的执行完整性。
     *
     * @param nums
     * @return
     */
    private int[] sort(int[] nums) {
        int[] result = new int[nums.length];
        AtomicInteger count = new AtomicInteger(0);
        for (int num : nums) {
            executor.execute(() -> {
                try {
                    Thread.sleep(num * 10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result[count.get()] = num;
                count.incrementAndGet();
            });
        }

//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            executor.execute(() -> {
//                try {
//                    Thread.sleep(num * 10L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                list.add(num);
//            });
//        }


        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                break;
            }
        }

        return result;
    }
}
