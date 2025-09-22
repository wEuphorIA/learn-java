package com.itheima.domain.dto;

import lombok.Data;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午6:30 */
@Data
public class StudentDto {

    private String name;

    private Integer degree;

    private Integer clazzId;

    private Integer page = 1; //页码

    private Integer pageSize = 10; //每页展示记录数


}
