package com.test.ioc.iocOrders.beanDefinition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Bean 工厂后置处理器，主要用于加载 Spring 中的 BeanDefinition。
 * <p>
 * 给使用者留下的扩展点，可以修改，新增BeanDefinition。因为此时所有的BeanDefinition已经加载，但是没有Bean被创建。
 * 一般用在需要覆盖或替换Bean的属性时
 * <p>
 * Spring 中元素加载情况: 项目中所有的 BeanDefinition 已被加载，但是普通 Bean 还未被实例化和初始化。
 * <p>
 * https://juejin.cn/post/6986656018969133092
 */
@Slf4j
@Component
public class CustomizeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * postProcessBeanFactory() 工作与 BeanDefinition 加载完成之后，Bean 实例化之前，可以在这个步骤对已经完成初始化的 BeanFactory 进行属性覆盖,
     * 其主要作用是对加载 BeanDefinition 进行修改。
     * <p>
     * 有一点需要需要注意的是在 postProcessBeanFactory() 中千万不能进行 Bean 的实例化工作，因为这样会导致 bean 过早实例化，会产生严重后果，
     * 我们始终需要注意的是 BeanFactoryPostProcessor 是与 BeanDefinition 打交道的，
     * <p>
     * 如果想要与 Bean 打交道，请使用 BeanPostProcessor
     * <p>
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        BeanDefinition learnIOC = beanFactory.getBeanDefinition("LearnIOC");
        log.debug("实例化前准备工作-5:BeanFactoryPostProcessor postProcessBeanFactory BeanDefinitionCount:{}", beanFactory.getBeanDefinitionCount());
//        log.debug("实例化前准备工作-5:BeanFactoryPostProcessor postProcessBeanFactory getBeanDefinition learnIOC:{}", learnIOC);
        log.info("实例化前准备工作-5:BeanFactoryPostProcessor postProcessBeanFactory configurableListableBeanFactory:{}", beanFactory);
    }
}