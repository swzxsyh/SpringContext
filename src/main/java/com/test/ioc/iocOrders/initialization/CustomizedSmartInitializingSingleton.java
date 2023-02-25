package com.test.ioc.iocOrders.initialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * 所有 Bean 实例化、初始化、并被所有后置处理器处理后的一个扩展点
 * 启动阶段，初始化所有非延迟单例Bean完成后，会回调这个方法，只会回调一次
 */
@Slf4j
@Component
public class CustomizedSmartInitializingSingleton implements SmartInitializingSingleton {


    @Override
    public void afterSingletonsInstantiated() {
        log.info("Bean 初始化完成阶段 初始化所有非延迟单例Bean并被所有后置处理器处理后的一个扩展点");
    }
}
