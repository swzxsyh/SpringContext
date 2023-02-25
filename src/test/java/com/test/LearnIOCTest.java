package com.test;

import com.test.domain.DisruptorMqService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Slf4j
@SpringBootTest(classes = LearnIOC.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//使用Spring Bean注入时需加RunWith注解
@RunWith(SpringRunner.class)
public class LearnIOCTest {

    @Autowired
    private DisruptorMqService disruptorMqService;

    /**
     * 项目内部使用Disruptor做消息队列
     *
     * @throws Exception
     */
    @Test
    public void sayHelloMqTest() throws Exception {
        disruptorMqService.sayHello("消息到了，Hello world!");
        log.info("消息队列已发送完毕");
        //这里停止2000ms是为了确定是处理消息是异步的
        Thread.sleep(2000);
    }

    @Test
    public void getNamesTest(){
        Flux.fromIterable(Arrays.asList("abc", "bcd")).subscribe(System.out::println);
        Flux.just("Hello","World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1,2,3}).subscribe(System.out::println);
    }
}
