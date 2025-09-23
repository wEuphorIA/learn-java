package com.itheima.d4_collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 上午9:45 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Comparable<Teacher>{
    private String name;
    private Integer age;
    private Double salary;

    @Override
    public int compareTo(Teacher o) {
        return age - o.age;
    }
}
