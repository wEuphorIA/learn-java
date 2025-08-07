package com.itheima.d4_interface.Demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午3:47 */
//第一步：定义Student实体类，封装学的姓名、性别、成绩
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String sex;
    private double score;
}
