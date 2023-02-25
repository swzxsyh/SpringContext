package com.test.ioc.iocOrders.initialization.aware.beanLevel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * invokeAwareMethods调用, 基本Aware
 * 剩余的在ApplicationContextAware.postProcessBeforeInitialization()进行调用
 */
@Slf4j
@Component
public class CustomizeInitializationAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {

    /**
     * BeanNameAware作用：让Bean对Name有知觉
     * 这个方法只是简单的返回我们当前的beanName,听官方的意思是这个接口更多的使用在spring的框架代码中，实际开发环境应该不建议使用
     *
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        log.debug("总Aware-1, 初始化基础Aware-1:BeanNameAware setBeanName:{}", s);
    }

    /**
     * 获取Bean的类装载器
     *
     * @param classLoader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    /**
     * 获取bean工厂，beanFactory让你可以不依赖注入方式，随意的读取IOC容器里面的对象，不过beanFactory本身还是要注入的。
     * 需要注意的是，一般情况下我们都用 @Component 注解，如果使用 @Configuration 注解的话，setBeanFactory方法会执行2次；
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.debug("总Aware-3, 初始化基础Aware-2:BeanFactoryAware setBeanFactory:{}", beanFactory.toString());
    }
}
