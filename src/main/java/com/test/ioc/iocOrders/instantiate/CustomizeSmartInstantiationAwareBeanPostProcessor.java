package com.test.ioc.iocOrders.instantiate;

import com.test.LearnIOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Slf4j
@Component
public class CustomizeSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    /**
     * Bean 实例化 阶段
     * <p>
     * 选择合适的构造器，如果返回的不为空，则用返回的构造函数实例化Bean，如果返回为null，则用无参数构造函数实例化Bean
     * AutowiredAnnotationBeanPostProcessor#determineCandidateConstructors 用来支持@Lookup注解，并且推断出要创建这个Bean需要的构造函数
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-已创建阶段: SmartInstantiationAwareBeanPostProcessor determineCandidateConstructors beanClass:{}, beanName:{}", beanClass, beanName);
        }
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }

    /**
     * Bean 实例化后 阶段
     * <p>
     * 发生循环依赖的对象会从ObjectFactory获取提前曝光的对象，而这个提前曝光的对象，
     * 会经过 SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference增强，然后返回
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-已创建阶段: SmartInstantiationAwareBeanPostProcessor getEarlyBeanReference bean:{}, beanName:{}", bean, beanName);
        }
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }
}
