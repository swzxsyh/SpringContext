package com.test.ioc.iocOrders.initialization.processor.containerLevel;

import com.test.LearnIOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Bean 的后置处理器，常用与对 Bean 的一些加工处理，比如最常见的动态代理
 * <p>
 * Spring 中元素加载情况: 项目中所有的 Bean 已创建，Bean 的属性已被自动装配。初始化方法还未被调用。
 * 例如在InitializingBean的afterPropertiesSet前，或则自定义的init-method前。
 * <p>
 * https://juejin.cn/post/6986656018969133092
 * https://www.jianshu.com/p/40131bb99194
 */
@Slf4j
@Component
public class CustomizeBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在每一个 Bean 初始化之前执行的方法, 容器级：有多少 Bean 调用多少次
     * <p>
     * ApplicationContextAwareProcessor#postProcessBeforeInitialization：用来回调ApplicationContext相关的一些接口
     * ConfigurationClassPostProcessor.ImportAwareBeanPostProcessor#postProcessBeforeInitialization：用来支持ImportAware接口
     * CommonAnnotationBeanPostProcessor#postProcessBeforeInstantiation：执行@PostConstruct标注的方法
     * AutowiredAnnotationBeanPostProcessor#postProcessBeforeInstantiation： return null
     * ApplicationListenerDetector#postProcessBeforeInitialization：直接return bean，没有做任何操作
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("初始化前置BeanPostProcessor postProcessBeforeInitialization bean, beanName:{}", beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 在每一个 Bean 初始化之后执行的方法, 容器级：有多少 Bean 调用多少次
     * <p>
     * 在Bean初始化后，调用方法postProcessAfterInitialization
     * <p>
     * CommonAnnotationBeanPostProcessor#postProcessBeforeInstantiation：
     * 在父类InitDestroyAnnotationBeanPostProcessor中有实现，return bean 在Bean初始化之后需要调用的对象
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("初始化后置BeanPostProcessor postProcessAfterInitialization bean, beanName:{}", beanName);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
