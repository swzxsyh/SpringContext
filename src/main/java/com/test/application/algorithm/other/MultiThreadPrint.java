package com.test.application.algorithm.other;

import java.util.concurrent.*;

public class MultiThreadPrint {

    private static final ExecutorService executors = new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        final MultiThreadPrint cls = new MultiThreadPrint();
        executors.execute(cls::printA);
        executors.execute(cls::printB);
        executors.execute(cls::printC);
    }

    private final CyclicBarrier cyclicBarrierA = new CyclicBarrier(2);
    private final CyclicBarrier cyclicBarrierB = new CyclicBarrier(2);
    private final CyclicBarrier cyclicBarrierC = new CyclicBarrier(3);


    public void printA() {

        try {
            while (true) {
                System.out.println("A");
                cyclicBarrierA.await();
                cyclicBarrierC.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            while (true) {

                cyclicBarrierA.await();
                System.out.println("B");
                cyclicBarrierB.await();
                cyclicBarrierC.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            while (true) {
                cyclicBarrierB.await();
                System.out.println("C");
                cyclicBarrierC.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
