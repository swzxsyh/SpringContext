package com.test.ioc.aop.use.cglib.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@Aspect
@Component
public class LogAspect {

    //    @Pointcut("@annotation(com.test.ioc.aop.use.cglib.log.LogAdvice)")
    @Pointcut("execution(* com.test.facade.controller.*.*(..))")
    public void validParam() {
    }

    @Around("validParam()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("aspect execute :{} start", joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof List) {
                continue;
            }
            if (arg instanceof String || arg instanceof Number) {
                log.info("param:{}", arg);
            }
        }


        Object result = joinPoint.proceed();

        if (result instanceof Callable) {
            log.info("result:{}", result);
        }

        log.info("aspect execute :{} end", joinPoint.getSignature().getName());


        return result;
    }
}
