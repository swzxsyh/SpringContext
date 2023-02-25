package com.test.ioc.iocOrders.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

/**
 * 将BeanDefinition保存到ConcurrentHashMap中
 * BeanDefinitionRegistry基本实现就是DefaultListableBeanFactory
 * <p>
 * 作用:用于存放bean定义的注册表的接口,例如RootBeanDefinition和ChildBeanDefinition实例。通常由内部使用AbstractBeanDefinition层次结构的BeanFactories实现.
 * 这是Spring的bean工厂包中唯一封装了bean定义注册的接口。标准的BeanFactory接口仅涵盖对完全配置的工厂实例的访问
 * <p>
 * https://www.jianshu.com/p/40131bb99194
 * https://z.itpub.net/article/detail/F00E621886219AB91092DB484E1A2BFA
 */
@Slf4j
@Component
public class CustomizeBeanDefinitionRegistry implements BeanDefinitionRegistry {

    @Override
    public void registerBeanDefinition(String s, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
    }

    @Override
    public void removeBeanDefinition(String s) throws NoSuchBeanDefinitionException {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
    }

    @Override
    public BeanDefinition getBeanDefinition(String s) throws NoSuchBeanDefinitionException {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return null;
    }

    @Override
    public boolean containsBeanDefinition(String s) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return false;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return new String[0];
    }

    @Override
    public int getBeanDefinitionCount() {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return 0;
    }

    @Override
    public boolean isBeanNameInUse(String s) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return false;
    }

    @Override
    public void registerAlias(String name, String alias) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
    }

    @Override
    public void removeAlias(String alias) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
    }

    @Override
    public boolean isAlias(String name) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return false;
    }

    @Override
    public String[] getAliases(String name) {
        log.debug("实例化前准备工作-3: BeanDefinitionRegistry");
        return new String[0];
    }
}
