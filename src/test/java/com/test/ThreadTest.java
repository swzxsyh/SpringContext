package com.test;

import org.junit.Test;

import java.util.Objects;

public class ThreadTest {
    /**
     * Thread execute 2 Times Exception
     * 需要用main方法，直接Test会在异常后中止（try-cache同样中止）,使用Test(expected)会不显示异常
     *
     * @param args
     */
//    @Test(expected = IllegalThreadStateException.class)
    public static void main(String[] args) {
        Thread noPrintRunThread = new Thread(MyRunnable::new);
        noPrintRunThread.run();
        noPrintRunThread.start();
        System.out.println("No Print End");
        System.out.println("Main thread running: " + Thread.currentThread().getName());

        Thread runThread = new Thread(new MyRunnable());
        runThread.run();
        System.out.println("run-1");
        runThread.run();
        System.out.println("run-2");


        Thread startThread1 = new Thread(new MyRunnable());
        startThread1.start();
        System.out.println("start-1");
        Thread startThread2 = new Thread(new MyRunnable());
        startThread2.start();
        System.out.println("start-2");
        startThread2.start();
        System.out.println("start-2 Again");
        //if (threadStatus != 0)
        //            throw new IllegalThreadStateException();
    }


    /**
     * JOIN Method
     *
     * @throws InterruptedException
     */
    @Test
    public void joinTest() throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable("Thread-1-"));
        Thread t2 = new Thread(new MyRunnable("Thread-2-"));
        Thread t3 = new Thread(new MyRunnable("Thread-3-"));

        t1.start();
        t1.join();

        t3.start();
        t3.join();

        t2.start();
        t2.join();

    }

    /**
     * IDEA Multi Thread Debug Test
     * <p></p>
     * https://www.bilibili.com/video/BV1Hf4y1t77J/
     */
    @Test
    public void debugMultiThreadTest() throws InterruptedException {
        new Thread(new MyRunnable("Thread-1-"), "T1").start();
        new Thread(new MyRunnable("Thread-2-"), "T2").start();
        new Thread(new MyRunnable("Thread-3-"), "T3").start();

        System.out.println("All Thread Executed");

    }


    static class MyRunnable implements Runnable {

        private String name;

        public MyRunnable() {
        }

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (Objects.isNull(name)) {
                        System.out.println("i:" + i);
                    } else {
                        System.out.println(name + "i:" + i);
                    }
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
