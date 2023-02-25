package com.test.ioc.iocOrders.destory.containerLevel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Bean 销毁前阶段
 */
@Slf4j
@Component
public class CustomizeDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    /**
     * 添加自定义的逻辑，例如修改对象属性等
     * InitDestroyAnnotationBeanPostProcessor#postProcessBeforeDestruction（CommonAnnotationBeanPostProcessor的父类）：被@PreDestory标注方法标注的方法
     *
     * @param bean
     * @param beanName
     * @throws BeansException
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        log.info("Bean 销毁前阶段DestructionAwareBeanPostProcessor,beanName:{}", beanName);
    }
}
