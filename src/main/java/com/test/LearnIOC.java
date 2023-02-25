package com.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Slf4j 日志
 * @EnableAspectJAutoProxy(proxyTargetClass = true)  开启AOP
 * @SpringBootApplication(scanBasePackages = {"com.test"})  扫描目录
 * @SpringBootApplication(scanBasePackages = {"com.test.loop.custom"})  不依赖
 * @SpringBootApplication(scanBasePackages = {"com.test.loop.loop"})  循环依赖
 * @SpringBootApplication(scanBasePackages = {"com.test.loop.loopAop"})  带AOP的循环依赖
 */
@Slf4j
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.test"})
@EnableTransactionManagement
//@SpringBootApplication(scanBasePackages = {"com.test.loop.custom"})
//@SpringBootApplication(scanBasePackages = {"com.test.loop.loop"})
//@SpringBootApplication(scanBasePackages = {"com.test.loop.loopAop"})
public class LearnIOC {

    public static void main(String[] args) {
        // SpringBoot run 方法
        SpringApplication.run(LearnIOC.class, args);

        // annotationConfigApplicationContext方法
        ///annotationConfigApplicationContext();

    }

    static void annotationConfigApplicationContext() {
        //this初始化组件
        //- 执行GenericApplicationContext无参构造函数,
        //- 执行beanFactory为DefaultListableBeanFactory
        //- 初始化 AnnotatedBeanDefinitionReader并注入6个Bean
        //  -  org.springframework.context.annotation.internalConfigurationAnnotationProcessor (实现了BeanFactoryPostProcessor，处理@Configuration，@ComponmentScan等注解，这是一个很重要的类)
        //  -  org.springframework.context.annotation.internalAutowiredAnnotationProcessor (实现了BeanPostProcessor，处理@Autowired，@Value等)
        //  -  org.springframework.context.annotation.internalCommonAnnotationProcessor (实现了BeanPostProcessor，用来处理JSR-250规范的注解，如@Resource，@PostConstruct等)
        //  -  PersistenceAnnotationBeanPostProcessor (实现了BeanFactoryPostProcessor，用来支持JPA)
        //  -  org.springframework.context.event.internalEventListenerProcessor (实现了BeanFactoryPostProcessor)
        //  -  org.springframework.context.event.internalEventListenerFactory
        //- 初始化ClassPathBeanDefinitionScanner
        //register注册配置类
        //- 将配置类转为BeanDefinition并注册到BeanDefinitionRegistry
        //refresh刷新容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}

@Configuration
@ComponentScan(basePackages = "com.test")
@ConditionalOnMissingBean(LearnIOC.class)
class AppConfig {

}

