package com.test.ioc.aop.use.cglib.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogAdvice {
}
