package day04.day4collection.practice2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 下午8:22 */
//Student类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String address;
}
