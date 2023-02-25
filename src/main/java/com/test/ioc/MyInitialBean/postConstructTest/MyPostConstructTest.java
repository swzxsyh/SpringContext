package com.test.ioc.MyInitialBean.postConstructTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class MyPostConstructTest {

    /**
     * 在bean对象内添加@PostConstruct 注解后即可实现初始化的功能，被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。 有多个则会执行多次；
     * 注意： 如果spring 实现了 BeanPostProcessor接口的postProcessBeforeInitialization() 方法，也就是12的初始后置方法，那么@PostConstruct注解会失效；
     * <p>
     * 优先级：@PostConstruct > InitializingBean.afterPropertiesSet() > @Bean(initMethod=”X”)
     */
    @PostConstruct
    public void init() {
        log.debug("初始化MyPostConstructTest PostConstruct init.......");
    }

    /**
     * 多例模式下，spring无法进行管理
     * 如果是ConfigurableBeanFactory.SCOPE_PROTOTYPE会将生命周期交给用户控制，用户用完bean对象后，java垃圾处理器会自动将无用的对象进行回收操作；
     */
    @PreDestroy
    public void destroy() {
        log.debug("销毁MyPostConstructTest PreDestroy destroy.......");
    }
}
