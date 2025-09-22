package day02.oophight;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午8:46 */
public class Practice3 {
    public static void main(String[] args) {
        // 创建4个Student对象
        Student[] students = {
                new Student("张三", 20,188.0),
                new Student("李四", 18,188.0),
                new Student("王五", 22,188.0),
                new Student("赵六", 19,188.0)
        };
        Arrays.sort(students,(s1,s2) -> s1.getAge()-s2.getAge());
        System.out.println("按年龄升序：");
        System.out.println(Arrays.toString(students));
    }
}
