package day08.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:05 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String name;
    private int age;
    private String subject;
}
