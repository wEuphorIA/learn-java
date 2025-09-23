package day05.stream.practice6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午8:22 */
public class Practice6 {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三",20));
        list.add(new Student("李四",18));
        list.add(new Student("王五",19));
        list.add(new Student("赵六",25));
        list.add(new Student("王炸",28));
        list.add(new Student("小王",26));
        list.add(new Student("大王",24));
        list.add(new Student("蘑菇头",23));
        list.add(new Student("妹爷",29));
        list.add(new Student("老王",30));
        list.add(new Student("老李",22));

        List<Student> collect = list.stream().filter(s -> s.getAge() > 20).limit(8).skip(2).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
