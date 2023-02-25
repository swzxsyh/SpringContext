package com.test.ioc.iocOrders.destory.beanLevel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomizeDisposableBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        log.info("执行DisposableBean destroy");
    }
}
