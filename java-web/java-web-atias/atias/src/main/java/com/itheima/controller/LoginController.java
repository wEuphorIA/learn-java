package com.itheima.controller;

import com.itheima.common.LoginInfo;
import com.itheima.common.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/9 上午9:55 */
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private EmpService service;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> dto){
        LoginInfo result = service.login(dto);

        if (result == null){
            return Result.error("账号密码错误");
        }
        return Result.success(result);
    }
}
