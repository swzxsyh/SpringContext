package com.test.ioc.iocOrders.bean.beanDefinitionReader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomizePropertiesBeanDefinitionReader extends PropertiesBeanDefinitionReader {
    /**
     * Create new PropertiesBeanDefinitionReader for the given bean factory.
     *
     * @param registry the BeanFactory to load bean definitions into,
     *                 in the form of a BeanDefinitionRegistry
     */
    public CustomizePropertiesBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
        log.debug("执行解析：PropertiesBeanDefinitionReader");
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        return super.loadBeanDefinitions(resource);
    }
}
