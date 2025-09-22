package com.itheima.d3_lambda.demo4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午2:56 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private Double height;

    public  int compareByAge(Student s1, Student s2)
    {
        return s1.getAge() - s2.getAge();
    }
}
