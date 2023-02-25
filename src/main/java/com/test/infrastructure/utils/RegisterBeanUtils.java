package com.test.infrastructure.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 非Spring管理Bean获取
 * TODO 未知使用场景
 * <p>这里使用Singleton AnnotationConfigApplicationContext会导致重复bind异常
 * 或
 * GenericApplicationContext does not support multiple refresh attempts:</p>
 *
 * @author swzxsyh
 */
@Slf4j
public class RegisterBeanUtils {

    /**
     * 外部单体对象
     *
     * @param beanName
     * @param clz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> clz) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
            //注册一个对象
            beanFactory.registerSingleton(beanName, clz);
            //启动Spring上下文
            applicationContext.refresh();
            //FIXME 返回的Class无法转换
            return (T) applicationContext.getBean(beanName);
        }
    }

    /**
     * BeanDefinition(BeanDefinitionRegistry)
     *
     * @param beanName
     * @param clz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T definitionGetBean(String beanName, Class<T> clz) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            registerBean(applicationContext, beanName, clz);
            //启动Spring上下文
            applicationContext.refresh();
            //依赖查找
            return (T) applicationContext.getBean(beanName);
        } catch (Exception e) {
            log.error("getBean error:", e);
        }
        return null;
    }


    private static <T> void registerBean(BeanDefinitionRegistry registry, String beanName, Class<T> clz) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clz);
        registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
    }
}
