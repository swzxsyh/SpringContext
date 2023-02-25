package com.test.ioc.iocOrders.initialization.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletContextAware;
import org.springframework.context.ApplicationStartupAware;

import javax.servlet.ServletContext;

/**
 * 回调为什么分成两个，这个为什么后面调用: 当我们启动的容器是ApplicationContext时，对这些接口进行了实现，此时才能注入进来
 *
 * Spring ApplicationContextAware.postProcessBeforeInitialization() 初始化前置调用
 * EnvironmentAware, EmbeddedValueResolverAware,
 * ResourceLoaderAware, ApplicationEventPublisherAware, ApplicationStartupAware, ApplicationContextAware
 * <p>
 * Tomcat Servlet使用
 */
@Slf4j
@Component
public class OtherAwareInterface implements EnvironmentAware, EmbeddedValueResolverAware,
        ResourceLoaderAware, ApplicationEventPublisherAware, ApplicationStartupAware, ApplicationContextAware,
        MessageSourceAware, ServletContextAware, LoadTimeWeaverAware, ImportAware {


    /**
     * 实现了EnvironmentAware接口重写setEnvironment方法后，在工程启动时可以获得application.properties 、xml、yml 的配置文件配置的属性值
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        log.debug("总Aware-4: 我是 EnvironmentAware 的 setEnvironment 方法, environment:{}", environment);
    }

    /**
     * 通常我们使用@Value注解来获取properties 和 yml 文件中的值，每个类中都要使用@Value也很繁琐
     * 实现EmbeddedValueResolverAware接口后就方便多了。用法也跟@Value一样，需要用${}包裹住；
     *
     * @param stringValueResolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        log.debug("总Aware-5: 我是 EmbeddedValueResolverAware 的 setEmbeddedValueResolver 方法, stringValueResolver:{}", stringValueResolver);
    }

    /**
     * Spring ResourceLoader为我们提供了一个统一的getResource()方法来通过资源路径检索外部资源。
     * 从而将资源或文件(例如文本文件、XML文件、属性文件或图像文件)加载到Spring应用程序上下文中的不同实现 ，就是用来加载外部资源的；
     * 方法中有个参数：ResourceLoader ，这个参数其实就是ApplicationContext（spring 的上下文对象）；可直接强转；
     *
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.debug("总Aware-6: 我是 ResourceLoaderAware 的 setResourceLoader 方法, resourceLoader:{}", resourceLoader);
    }

    /**
     * ApplicationEventPublisherAware是一个事件发布器的接口，使用这个接口，我们自己的 Service 就拥有了发布事件的能力。
     * 用户注册后，不再是显示调用其他的业务 Service，而是发布一个用户注册事件。
     * 那么在这里是发布事件，那就肯定有监听事件的接口，这个接口叫做 ApplicationListener  ，只要实现ApplicationListener 接口就可以接受发布的事件了
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.debug("总Aware-7: 我是 ApplicationEventPublisherAware 的 setApplicationEventPublisher 方法, applicationEventPublisher:{}", applicationEventPublisher);
        StringEvent stringEvent = new StringEvent("测试消息发布");
        applicationEventPublisher.publishEvent(stringEvent);
    }

    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        log.info("我是 ApplicationStartupAware setApplicationStartup:{}", applicationStartup);
    }

    static class StringEvent extends ApplicationEvent {

        private String str;

        // 构造函数
        public StringEvent(Object source) {
            super(source);
            str = source.toString();
        }

        // 获取字符串
        public String getStr() {
            return str;
        }
    }

    /**
     * 国际化消息通知操作
     *
     * @param messageSource
     */
    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.debug("总Aware-8: 我是 MessageSourceAware 的 setMessageSource 方法, messageSource:{}", messageSource);
    }

    /**
     * ApplicationContextAware 主要用来全局获取 ApplicationContext 上下文，ApplicationContext其实就是容器，
     * 为此我们可以实现ApplicationContextAware 接口来获取ApplicationContext容器对象；
     * 我们可以把它做成一个公共的静态类，这样可以在任意地方想拿就拿了，
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("总Aware-9, 初始化基础Aware-3:ApplicationContextAware setApplicationContext:{}", applicationContext);
    }

    /**
     * 通过实现ServletContextAware接口可获取servletContext，也就是servlet的上下文；
     * 什么是ServletContext ： WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
     * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，可以通过ServletConfig.getServletContext方法获得ServletContext对象。
     * <p>
     * 由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。
     * ServletContext对象通常也被称之为context域对象。
     *
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        log.debug("总Aware-10: 我是 ServletContextAware 的 setServletContext 方法, servletContext:{}", servletContext);
    }

    /**
     * LoadTimeWeaver 简称LTW，LTW是AOP的一种实现方式，此方法是为了获取Aop织入的对象，使用的织入方式是：类加载期织入，
     * 一般的aop都是运行期织入，就是在运行的时候才进行织入切面方法，但是LTW是在类加载前就被织入了，也就是class文件在jvm加载之前进行织入切面方法
     * 只有在使用 @EnableLoadTimeWeaving 或者存在 LoadTimeWeaver 实现的 Bean 时才会调用，顺序也很靠后
     *
     * @param loadTimeWeaver
     */
    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        log.debug("总Aware-11: 我是 LoadTimeWeaverAware 的 setLoadTimeWeaver 方法, loadTimeWeaver{}", loadTimeWeaver);
    }

    /**
     * 只有被其他配置类 @Import(XX.class) 时才会调用，这个调用对 XX.class 中的所有 @Bean 来说顺序是第 1 的。
     *
     * @param annotationMetadata
     */
    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        //只有被其他配置类 @Import(XX.class) 时才会调用，这个调用对 XX.class 中的所有 @Bean 来说顺序是第 1 的。
        log.debug("总Aware-12: 我是 ImportAware 的 setImportMetadata 方法, annotationMetadata:{}", annotationMetadata);
    }
}
