package com.itheima.d3_lambda.demo3;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午2:59 */
public class Demo1 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("小王", 18, 180.5),
                new Student("小张", 23, 180.5),
                new Student("小李", 20, 180.5),
                new Student("小赵", 21, 180.5),
                new Student("小王", 18, 180.0),
        };

        // Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
        //如果某个Lambda表达式里只是调用一个静态方法，并且"→"前后参数的形式一致，就可以使用静态方法引l用。
        Arrays.sort(students, Student::compareByAge);
        System.out.println(Arrays.toString(students));

    }

}
