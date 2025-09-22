package com.itheima.controller;

import com.itheima.common.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午12:21 */
@RestController
@Slf4j
public class UploadController {


    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;


    @PostMapping("/upload")
    public Result upload(MultipartFile file){

        try {
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            return Result.success(url);
        } catch (Exception e) {
            return Result.error("上传失败");
        }

    }
}
