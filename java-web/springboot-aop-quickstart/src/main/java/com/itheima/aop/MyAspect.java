package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/11 上午10:24 */
@Component
@Aspect
@Slf4j
public class MyAspect {

    // @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")

    // @Pointcut("execution(* com..service.*.*(..))")
    // @Pointcut("execution(public void com..*.service.*.*(..))")
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("环绕通知前");
        Object proceed = pjp.proceed();
        log.info("环绕通知后");
        return proceed;
    }

    @Before("pt()")
    public void before(){
        log.info("前置通知");
    }

    @After("pt()")
    public void after(){
        log.info("后置通知");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("返回通知");//有异常的话就不执行
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("异常通知");
    }
}
