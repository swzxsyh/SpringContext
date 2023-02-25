package com.test.ioc.iocOrders.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * AbstractApplicationContext #refresh loadBeanDefinitions()方法进行加载
 * 这里Bean不会被Spring加载, 日志无法打印
 */
@Slf4j
@Component
public abstract class CustomizeAbstractApplicationContext extends AbstractApplicationContext {

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        log.debug("实例化前准备工作-1:AbstractApplicationContext refreshBeanFactory");
    }

    @Override
    protected void closeBeanFactory() {
        log.debug("实例化前准备工作-1:AbstractApplicationContext closeBeanFactory");
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        log.debug("实例化前准备工作-1:AbstractApplicationContext getBeanFactory");
        return null;
    }

    @Override
    public void refresh() throws BeansException, IllegalStateException {
        log.debug("实例化前准备工作-1:AbstractApplicationContext refresh");
        super.refresh();
    }

    @Override
    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        log.debug("实例化前准备工作-1:AbstractApplicationContext obtainFreshBeanFactory");
        return null;
    }
}
