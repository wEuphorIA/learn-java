package com.itheima.aspect;


import com.itheima.domain.pojo.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.service.AsyncLogService;
import com.itheima.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/11 上午11:56 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private AsyncLogService asyncLogService; // 注入异步服务

    @Pointcut("@annotation(com.itheima.annotation.LogOperation)")
    public void pt(){}

    @Around("pt()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

        // 1. 初始化日志对象和开始时间
        OperateLog operateLog = new OperateLog();
        long start = System.currentTimeMillis();
        Object result = null; // 先初始化为null
        boolean isSuccess = false; // 用于标记方法是否执行成功

        try {
            // 2. 执行目标方法
            result = pjp.proceed();
            isSuccess = true; // 如果执行到这一步，说明没有异常
            return result; // 返回结果

        } finally {
            // 4. 【无论成功失败，最终都会执行】组装日志通用信息
            long end = System.currentTimeMillis();
            long costTime = end - start;

            operateLog.setOperateEmpId(CurrentHolder.getCurrentId());
            operateLog.setOperateTime(LocalDateTime.now());
            operateLog.setClassName(pjp.getTarget().getClass().getName());
            operateLog.setMethodName(pjp.getSignature().getName());
            operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
            operateLog.setCostTime(costTime);

            // 5. 只有成功时才记录返回值，避免对null进行操作或转换失败
            if (isSuccess && result != null) {
                // 安全地处理返回值，避免ClassCastException
                operateLog.setReturnValue(result.toString());
            } else if (isSuccess) {
                operateLog.setReturnValue("null");
            } else {
                // 失败时，返回值可能为null或不确定，可以选择不记录或记录为特定值
                operateLog.setReturnValue("N/A (Method Failed)");
            }

            // 6. 【异步记录日志】
            try {
                asyncLogService.asyncInsertOperateLog(operateLog);
            } catch (Exception e) {
                // 日志记录本身的异常不应影响主业务逻辑
                log.error("异步记录操作日志失败", e);
            }
        }
    }
}
