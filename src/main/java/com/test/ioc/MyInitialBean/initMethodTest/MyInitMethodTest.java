package com.test.ioc.MyInitialBean.initMethodTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyInitMethodTest {

    public void init_method() {
        log.debug("初始化MyInitMethodTest init method.......");
    }

    /**
     * 多例模式下，spring无法进行管理
     * 如果是ConfigurableBeanFactory.SCOPE_PROTOTYPE会将生命周期交给用户控制，用户用完bean对象后，java垃圾处理器会自动将无用的对象进行回收操作；
     */
    public void destroy_method() {
        log.debug("销毁MyInitMethodTest destroy method.......");
    }
}
