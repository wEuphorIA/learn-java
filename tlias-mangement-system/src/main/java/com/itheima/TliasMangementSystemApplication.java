package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.itheima.mapper")
@EnableScheduling
public class TliasMangementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasMangementSystemApplication.class, args);
    }

}
