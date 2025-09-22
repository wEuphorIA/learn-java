package com.aliyun.oss;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/12 下午4:56 */
@Configuration
@EnableConfigurationProperties(AliyunOSSProperties.class)
public class AliOSSAutoConfiguration {

    @Bean
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties){
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
