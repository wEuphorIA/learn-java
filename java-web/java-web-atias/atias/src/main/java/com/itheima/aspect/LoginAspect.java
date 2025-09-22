package com.itheima.aspect;

import com.itheima.common.LoginInfo;
import com.itheima.common.Result;
import com.itheima.domain.pojo.EmpLoginLog;
import com.itheima.mapper.EmpLoginLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/11 下午6:04 */
@Aspect
@Component
public class LoginAspect {

    @Autowired
    private EmpLoginLogMapper empLoginLogMapper;


    @Pointcut("execution(* com.itheima.controller.LoginController.*(..))")
    public void pt() {
    }


    @Around("pt()")
    public Object around(ProceedingJoinPoint point) throws Throwable {


        EmpLoginLog empLoginLog = new EmpLoginLog();
        long start = System.currentTimeMillis();

        Integer code = 0;
        LoginInfo loginInfo = null;
        try {

            Object proceed = point.proceed();
            Result result = (Result) proceed;
            code = result.getCode();
            Object data = result.getData();
            loginInfo = (LoginInfo) data;
            return proceed;
        } finally {
            long end = System.currentTimeMillis();
            empLoginLog.setCostTime(end - start);
            empLoginLog.setLoginTime(LocalDateTime.now());
            Object[] args = point.getArgs();
            if (args != null && args.length > 0) {
                Map<String, Object> arg = (Map<String, Object>) args[0];
                String username = (String) arg.get("username");
                String password = (String) arg.get("password");
                empLoginLog.setUsername(username);
                empLoginLog.setPassword(password);
            }

            if (code.equals(1)){
                empLoginLog.setIsSuccess((short) 1);
            }else {
                empLoginLog.setIsSuccess((short) 0);
            }
            if (loginInfo != null) {
                empLoginLog.setJwt(loginInfo.getToken());
            }

            empLoginLogMapper.insert(empLoginLog);

        }

    }
}
