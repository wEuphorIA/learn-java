package com.itheima.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/31 下午5:54 */
@Data
public class EmpDto {

    private Integer page = 1; //页码

    private Integer pageSize = 10; //每页展示记录数

    private String name; //姓名
    private Integer gender; //性别

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //入职开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //入职结束时间

}
