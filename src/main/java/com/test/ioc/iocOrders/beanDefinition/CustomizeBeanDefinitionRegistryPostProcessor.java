package com.test.ioc.iocOrders.beanDefinition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 可以在这个步骤添加新的 BeanDefinition 到 BeanFactory 中
 * <p>
 * Spring 中元素加载情况： 项目中所有的 BeanDefinition 已被加载，但是普通 Bean 还未被实例化和初始化。
 * <p>
 * https://juejin.cn/post/6986656018969133092
 */
@Slf4j
@Component
public class CustomizeBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * 扫描添加项目中的 BeanDefinition
     *
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        log.info("实例化前准备工作-4:BeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry beanDefinitionRegistry:{}", beanDefinitionRegistry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] singletonNames = configurableListableBeanFactory.getSingletonNames();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < singletonNames.length; i++) {
            sb.append(singletonNames[i]).append(',');
        }

        log.debug(sb.toString());
        log.info("实例化前准备工作-4:BeanDefinitionRegistryPostProcessor postProcessBeanFactory configurableListableBeanFactory:{}", configurableListableBeanFactory);
    }
}
