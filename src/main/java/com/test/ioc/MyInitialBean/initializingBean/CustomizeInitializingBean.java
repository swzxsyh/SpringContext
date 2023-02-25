package com.test.ioc.MyInitialBean.initializingBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 初始化方法二: InitializingBean.afterPropertiesSet()
 *
 * 初始化方法一：@PostConstruct
 * 初始化方法三: @Bean(initMethod = "init_method")
 *
 * 顺序: @PostConstruct > InitializingBean.afterPropertiesSet() > @Bean(initMethod = "init_method")
 */
@Slf4j
@Component
public class CustomizeInitializingBean implements InitializingBean {

    private final ApplicationContext applicationContext;

    public CustomizeInitializingBean(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String applicationName = applicationContext.getApplicationName();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            sb.append(beanDefinitionNames[i]);
            sb.append(',');
        }
        log.debug("初始化InitializingBean afterPropertiesSet applicationContext applicationName:{},beanDefinitionNames:{}", applicationName, sb.toString());
    }
}
