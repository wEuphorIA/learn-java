package day04.day4collection.practice2;

import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 下午8:22 */
public class Practice2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张无忌", "河北"));
        list.add(new Student(2, "张三丰", "河南"));
        list.add(new Student(3, "赵敏", "蒙古"));
        list.add(new Student(4, "周芷若", "四川"));
        System.out.println("修改前");
        System.out.println(list);

        for (Student s : list) {
            extracted(s);
        }
        System.out.println("修改后");
        System.out.println(list);
    }

    private static void extracted(Student s) {
        if ("张三丰".equals(s.getName())) {
            s.setAddress("武汉");
        }
    }
}
