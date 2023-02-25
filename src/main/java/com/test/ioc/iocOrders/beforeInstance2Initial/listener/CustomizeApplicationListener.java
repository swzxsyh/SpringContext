package com.test.ioc.iocOrders.beforeInstance2Initial.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * refresh 注册BeanPostProcessors后-3
 */
@Slf4j
@Component
public class CustomizeApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("监听到事件ApplicationListener onApplicationEvent event:{}", event);
    }
}
