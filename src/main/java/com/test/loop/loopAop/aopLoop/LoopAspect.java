package com.test.loop.loopAop.aopLoop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoopAspect {

    @Pointcut("execution(* com.test.loop.loopAop.impl.*.log(..))")
    public void loopAop() {
    }

    @Around("loopAop()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP LOOP :{} 开始", joinPoint.getSignature().getName());


        return joinPoint.proceed();
    }
}
