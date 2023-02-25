package com.test.ioc.iocOrders.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * 将所有Bean经Reader解析成BeanDefinition
 */
@Slf4j
@Component
public class CustomizeBeanDefinition implements BeanDefinition {

    @Override
    public void setParentName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setParentName:{}", s);
    }

    @Override
    public String getParentName() {
        log.debug("实例化前准备工作-2: BeanDefinition getParentName");
        return null;
    }

    @Override
    public void setBeanClassName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setBeanClassName:{}", s);
    }

    @Override
    public String getBeanClassName() {
        log.debug("实例化前准备工作-2: BeanDefinition getBeanClassName");
        return null;
    }

    @Override
    public void setScope(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setScope:{}", s);
    }

    @Override
    public String getScope() {
        log.debug("实例化前准备工作-2: BeanDefinition getScope");
        return null;
    }

    @Override
    public void setLazyInit(boolean b) {
        log.debug("实例化前准备工作-2: BeanDefinition setLazyInit:{}", b);
    }

    @Override
    public boolean isLazyInit() {
        log.debug("实例化前准备工作-2: BeanDefinition isLazyInit");
        return false;
    }

    @Override
    public void setDependsOn(String... strings) {
        log.debug("实例化前准备工作-2: BeanDefinition setDependsOn,{}", strings);
    }

    @Override
    public String[] getDependsOn() {
        log.debug("实例化前准备工作-2: BeanDefinition getDependsOn");
        return new String[0];
    }

    @Override
    public void setAutowireCandidate(boolean b) {
        log.debug("实例化前准备工作-2: BeanDefinition ");
    }

    @Override
    public boolean isAutowireCandidate() {
        log.debug("实例化前准备工作-2: BeanDefinition isAutowireCandidate");
        return false;
    }

    @Override
    public void setPrimary(boolean b) {
        log.debug("实例化前准备工作-2: BeanDefinition setPrimary:{}", b);
    }

    @Override
    public boolean isPrimary() {
        log.debug("实例化前准备工作-2: BeanDefinition isPrimary");
        return false;
    }

    @Override
    public void setFactoryBeanName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setFactoryBeanName:{}", s);
    }

    @Override
    public String getFactoryBeanName() {
        log.debug("实例化前准备工作-2: BeanDefinition getFactoryBeanName");
        return null;
    }

    @Override
    public void setFactoryMethodName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setFactoryMethodName:{}", s);
    }

    @Override
    public String getFactoryMethodName() {
        log.debug("实例化前准备工作-2: BeanDefinition getFactoryMethodName");
        return null;
    }

    @Override
    public ConstructorArgumentValues getConstructorArgumentValues() {
        log.debug("实例化前准备工作-2: BeanDefinition getConstructorArgumentValues");
        return null;
    }

    @Override
    public MutablePropertyValues getPropertyValues() {
        log.debug("实例化前准备工作-2: BeanDefinition getPropertyValues");
        return null;
    }

    @Override
    public void setInitMethodName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setInitMethodName:{}", s);
    }

    @Override
    public String getInitMethodName() {
        log.debug("实例化前准备工作-2: BeanDefinition getInitMethodName");
        return null;
    }

    @Override
    public void setDestroyMethodName(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setDestroyMethodName:{}", s);
    }

    @Override
    public String getDestroyMethodName() {
        log.debug("实例化前准备工作-2: BeanDefinition getDestroyMethodName");
        return null;
    }

    @Override
    public void setRole(int i) {
        log.debug("实例化前准备工作-2: BeanDefinition setRole:{}", i);
    }

    @Override
    public int getRole() {
        log.debug("实例化前准备工作-2: BeanDefinition getRole");
        return 0;
    }

    @Override
    public void setDescription(String s) {
        log.debug("实例化前准备工作-2: BeanDefinition setDescription:{}", s);
    }

    @Override
    public String getDescription() {
        log.debug("实例化前准备工作-2: BeanDefinition getDescription");
        return null;
    }

    @Override
    public ResolvableType getResolvableType() {
        log.debug("实例化前准备工作-2: BeanDefinition getResolvableType");
        return null;
    }

    @Override
    public boolean isSingleton() {
        log.debug("实例化前准备工作-2: BeanDefinition isSingleton");
        return false;
    }

    @Override
    public boolean isPrototype() {
        log.debug("实例化前准备工作-2: BeanDefinition isPrototype");
        return false;
    }

    @Override
    public boolean isAbstract() {
        log.debug("实例化前准备工作-2: BeanDefinition isAbstract");
        return false;
    }

    @Override
    public String getResourceDescription() {
        log.debug("实例化前准备工作-2: BeanDefinition getResourceDescription");
        return null;
    }

    @Override
    public BeanDefinition getOriginatingBeanDefinition() {
        log.debug("实例化前准备工作-2: BeanDefinition getOriginatingBeanDefinition");
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {
        log.debug("实例化前准备工作-2: BeanDefinition setAttribute name:{}, value:{}", name, value);
    }

    @Override
    public Object getAttribute(String name) {
        log.debug("实例化前准备工作-2: BeanDefinition getAttribute:{}", name);
        return null;
    }

    @Override
    public Object removeAttribute(String name) {
        log.debug("实例化前准备工作-2: BeanDefinition removeAttribute:{}", name);
        return null;
    }

    @Override
    public boolean hasAttribute(String name) {
        log.debug("实例化前准备工作-2: BeanDefinition hasAttribute:{}", name);
        return false;
    }

    @Override
    public String[] attributeNames() {
        log.debug("实例化前准备工作-2: BeanDefinition attributeNames");
        return new String[0];
    }
}
