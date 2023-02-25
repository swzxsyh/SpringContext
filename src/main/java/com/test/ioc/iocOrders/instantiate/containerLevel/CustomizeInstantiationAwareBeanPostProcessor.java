package com.test.ioc.iocOrders.instantiate.containerLevel;

import com.test.LearnIOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Bean 实例化阶段
 */
@Slf4j
@Component
public class CustomizeInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化前置
     * <p>
     * 对在对象实例化之前对bean对象的class信息进行修改或者扩展，以达到我们想要的功能，它的底层是动态代理AOP技术实现的；且是bean生命周期中最先执行的方法
     *
     * @param beanClass
     * @param beanName
     * @return 返回非空：返回值是Object类型，这意味着我们可以返回任何类型的值，由于这个时候目标对象还未实例化，所以这个返回值可以用来代替原本该生成对象的目标对象的实例，
     * 也就是说，如果返回了非空的值，那么以后我们需要用到这个bean的时候，拿到的就现在返回的对象了，也就不会去走第二步去实例化对象了；
     * <p>
     * 返回空（null）值：默认也是返回null值的，那么就直接返回，接下来会调用doCreateBean方法来实例化对象；
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-1 未创建 前置InstantiationAwareBeanPostProcessor postProcessBeforeInstantiation beanClass:{},beanName:{}", beanClass, beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 实例化后置 Bean 属性赋值前阶段
     * <p>
     * 在目标对象实例化之后调用，这个时候对象已经被实例化，但是该实例的属性还未被设置，都是null。
     * 因为他的返回值是决定要不要调用postProcessPropertyValues方法中的一个因素(因为还有一个因素是mbd.getDependencyCheck());
     *
     * @param bean
     * @param beanName
     * @return 返回false ：如果该方法返回false，并且不需要check，那么postProcessPropertyValues就会被忽略不执行；
     * 返回true ： 如果返回true，postProcessPropertyValues就会被执行
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-3 已创建后处理 后置InstantiationAwareBeanPostProcessor postProcessAfterInstantiation bean, beanName:{}", beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 属性修改
     * <p>
     * 对属性值进行修改，postProcessProperties用来替代postProcessPropertyValues
     * 修改范围包括添加、修改、删除操作；，如果实例化后置 postProcessAfterInstantiation() 方法返回false，那么该方法不会被调用
     * <p>
     * AutowiredAnnotationBeanPostProcessor#postProcessProperties：查找被@Autowired和@Value标注的方法或属性，并且注入需要的值
     * CommonAnnotationBeanPostProcessor#postProcessProperties：查找被@WebServiceRef，@EJB，@Resource标注的属性，并且注入需要的值
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-4 已创建后处理 属性修改InstantiationAwareBeanPostProcessor postProcessProperties pvs:{}, bean, beanName:{}", pvs, beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

///    @Deprecated
///    @Override
///    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
///        return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
///    }

///    @Override
///    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
///        log.debug("实例化InstantiationAwareBeanPostProcessor postProcessBeforeInitialization bean:{}, beanName:{}", bean, beanName);
///        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
///    }
///
///    @Override
///    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
///        log.debug("实例化InstantiationAwareBeanPostProcessor postProcessAfterInitialization bean:{}, beanName:{}", bean, beanName);
///        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
///    }
}
