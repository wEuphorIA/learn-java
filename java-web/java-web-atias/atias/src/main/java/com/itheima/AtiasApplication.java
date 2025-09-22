package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@EnableAsync // 开启异步任务支持
public class AtiasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtiasApplication.class, args);
    }

}
