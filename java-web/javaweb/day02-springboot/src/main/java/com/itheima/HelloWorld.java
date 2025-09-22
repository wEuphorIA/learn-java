package com.itheima;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 上午9:29 */
@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("hello" + name);
        return "hello" + name;
    }
}
