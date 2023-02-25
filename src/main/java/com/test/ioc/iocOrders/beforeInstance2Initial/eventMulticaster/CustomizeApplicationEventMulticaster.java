package com.test.ioc.iocOrders.beforeInstance2Initial.eventMulticaster;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * BeanDefinition之后 到初始化之前 执行 , refresh 注册BeanPostProcessors后-2
 * 在initMessageSource 后执行
 *
 * Debug Breakpoint 无效
 */
@Slf4j
@Component
public class CustomizeApplicationEventMulticaster implements ApplicationEventMulticaster {

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        log.debug("CustomizeApplicationEventMulticaster addApplicationListener listener:{}", listener);
    }

    @Override
    public void addApplicationListenerBean(String listenerBeanName) {
        log.debug("CustomizeApplicationEventMulticaster addApplicationListenerBean listenerBeanName:{}", listenerBeanName);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        log.debug("CustomizeApplicationEventMulticaster removeApplicationListener listener:{}", listener);
    }

    @Override
    public void removeApplicationListenerBean(String listenerBeanName) {
        log.debug("CustomizeApplicationEventMulticaster removeApplicationListenerBean listenerBeanName:{}", listenerBeanName);
    }

    @Override
    public void removeApplicationListeners(Predicate<ApplicationListener<?>> predicate) {
        log.debug("CustomizeApplicationEventMulticaster removeApplicationListeners predicate:{}", predicate);
    }

    @Override
    public void removeApplicationListenerBeans(Predicate<String> predicate) {
        log.debug("CustomizeApplicationEventMulticaster removeApplicationListenerBeans predicate:{}", predicate);
    }

    @Override
    public void removeAllListeners() {
        log.debug("CustomizeApplicationEventMulticaster removeAllListeners");
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        log.debug("CustomizeApplicationEventMulticaster multicastEvent event:{}", event);
    }

    @Override
    public void multicastEvent(ApplicationEvent event, ResolvableType eventType) {
        log.debug("CustomizeApplicationEventMulticaster multicastEvent event:{}, eventType:{}", event, eventType);
    }
}
