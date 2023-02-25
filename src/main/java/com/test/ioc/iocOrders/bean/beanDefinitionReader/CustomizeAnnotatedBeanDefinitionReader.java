package com.test.ioc.iocOrders.bean.beanDefinitionReader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomizeAnnotatedBeanDefinitionReader extends AnnotatedBeanDefinitionReader {


    @Override
    public void register(Class<?>... componentClasses) {
        log.info("register");
        super.register(componentClasses);
    }

    @Override
    public void registerBean(Class<?> beanClass) {
        log.info("registerBean");
        super.registerBean(beanClass);
    }

    public CustomizeAnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry, Environment environment) {
        super(registry, environment);
    }
}
