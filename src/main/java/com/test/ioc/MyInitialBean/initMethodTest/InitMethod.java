package com.test.ioc.MyInitialBean.initMethodTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InitMethod {

    /**
     * bean 配置文件属性 init-method 用于在bean初始化时指定执行方法，用来替代继承 InitializingBean接口,
     * <p>
     * 注意的一点是只有一个类完整的实例被创建出来后，才能走初始化方法。
     * <p>
     * 优先级：@PostConstruct > InitializingBean.afterPropertiesSet() > @Bean(initMethod=”X”)
     *
     * @return
     */
    @Bean(initMethod = "init_method", destroyMethod = "destroy_method")
    public MyInitMethodTest getBeanTest() {
        log.debug("执行初始化与销毁InitMethod getBeanTest init_method && destroy_method");
        return new MyInitMethodTest();
    }
}
