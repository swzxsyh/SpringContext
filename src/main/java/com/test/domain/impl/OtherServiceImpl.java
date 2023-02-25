package com.test.domain.impl;

import com.test.domain.OtherService;

/**
 * 不加Service注解的实现类
 *
 * @author swzxsyh
 */
public class OtherServiceImpl implements OtherService {
    @Override
    public String getName() {
        return "name";
    }
}
