package day05.day5collection.practice1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/10 下午7:58 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private String sex;
    // public Student(String name, int age, String sex) {
    //     this.name = name;
    //     this.setAge(age);  // 构造时校验
    //     this.setSex(sex);
    // }

    public void setAge(int age) {
        if (age < 15 || age > 50){
            throw new AgeException("年龄异常");
        }
        this.age = age;
    }
    public void setSex(String sex) {
        if (!"男".equals(sex) && !"女".equals(sex)  ){
            throw new SexException("性别异常");
        }
        this.sex = sex;
    }
}
