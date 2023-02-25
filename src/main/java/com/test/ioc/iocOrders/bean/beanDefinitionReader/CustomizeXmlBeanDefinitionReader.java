package com.test.ioc.iocOrders.bean.beanDefinitionReader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomizeXmlBeanDefinitionReader extends XmlBeanDefinitionReader {
    /**
     * Create new XmlBeanDefinitionReader for the given bean factory.
     *
     * @param registry the BeanFactory to load bean definitions into,
     *                 in the form of a BeanDefinitionRegistry
     */
    public CustomizeXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
        log.debug("执行解析：XmlBeanDefinitionReader");
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        return super.loadBeanDefinitions(resource);
    }
}
