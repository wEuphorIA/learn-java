package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/11 上午9:43 */
@Component
@Aspect
public class RecordTimeAspect {


    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

        // 记录开始时间
        long start = System.currentTimeMillis();

        // 调用原始方法
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();

        System.out.println("时间差为" + (end - start));

        return result;
    }
}
