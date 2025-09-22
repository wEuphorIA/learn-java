package com.itheima.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/302:17 */
@Data
public class ClazzDto {

    private String name;

    private Integer page = 1; //页码

    private Integer pageSize = 10; //每页展示记录数

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //结束时间
}
