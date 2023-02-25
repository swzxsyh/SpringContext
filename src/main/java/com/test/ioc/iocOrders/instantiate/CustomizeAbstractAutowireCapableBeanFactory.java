package com.test.ioc.iocOrders.instantiate;

import com.test.LearnIOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.NamedBeanHolder;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class CustomizeAbstractAutowireCapableBeanFactory extends AbstractAutowireCapableBeanFactory {

    /**
     * 实例化第二步骤: 创建Bean，调用doCreateBean方法，Spring框架处理，debug只能进入上层方法
     *
     * @param beanName
     * @param mbd
     * @param args
     * @return
     * @throws BeanCreationException
     */
    @Override
    protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
            throws BeanCreationException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.debug("实例化-2 创建中处理 实例化对象AbstractAutowireCapableBeanFactory doCreateBean beanName:{}, RootBeanDefinition:{}, args:{}", beanName, mbd, args);
        }
        return super.doCreateBean(beanName, mbd, args);
    }

    /**
     * 属性赋值 populateBean: autowireByName && autowireByType 处理三级缓存
     * <p>
     * Populate the bean instance in the given BeanWrapper with the property values
     * from the bean definition.
     *
     * @param beanName the name of the bean
     * @param mbd      the bean definition for the bean
     * @param bw       the BeanWrapper with bean instance
     */
    @Override
    @SuppressWarnings("deprecation")  // for postProcessPropertyValues
    protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable BeanWrapper bw) {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("属性赋值-5 创建后填充属性 执行AbstractAutowireCapableBeanFactory populateBean beanName:{}, RootBeanDefinition:{}, BeanWrapper:{}", beanName, mbd, bw);
        }
    }

    @Override
    public <T> NamedBeanHolder<T> resolveNamedBean(Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public Object resolveDependency(DependencyDescriptor descriptor, String requestingBeanName, Set<String> autowiredBeanNames, TypeConverter typeConverter) throws BeansException {
        return null;
    }

    @Override
    protected boolean containsBeanDefinition(String beanName) {
        return false;
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
        return null;
    }
}
