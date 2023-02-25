package com.test.application.designPatten.creationalPattern.singletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoMultiThread {

    public static void main(String[] args) {
        log.info("If you see the same value, then singleton was reused (yay!) \n If you see different values, then 2 singletons were created (booo!!) \n\n RESULT: \n");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            log.info(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            log.info(singleton.value);
        }
    }
}
