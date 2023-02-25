package com.test.ioc.iocOrders.instantiate;

import com.test.LearnIOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Bean 实例化后阶段
 */
@Slf4j
@Component
public class CustomizeMergedBeanDefinitionPostProcessor extends CommonAnnotationBeanPostProcessor implements MergedBeanDefinitionPostProcessor {

    /**
     * MergedBeanDefinitionPostProcessor:
     * 解析@Autowired，@Value，@Inject，并将相关的信息保存下来，后续对Bean属性进行赋值的时候要用
     * <p>
     * CommonAnnotationBeanPostProcessor:
     * 解析@WebServiceRef，@EJB，@Resource，@PostConstruct，@PreDestroy，并将相关信息保存下来，
     * 后续对Bean属性赋值（@WebServiceRef，@EJB，@Resource），生命周期（@PostConstruct，@PreDestroy）提供支持
     *
     * @param beanDefinition
     * @param beanType
     * @param beanName
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if (beanName.equalsIgnoreCase(LearnIOC.class.getSimpleName())) {
            log.info("实例化-已创建阶段: MergedBeanDefinitionPostProcessor CommonAnnotationBeanPostProcessor postProcessMergedBeanDefinition postProcessMergedBeanDefinition RootBeanDefinition:{}, beanType:{}, beanName:{}",
                    beanDefinition, beanType, beanName);
        }
    }
}
