package day3_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 上午10:19
 */
//
public class Student1 {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三",20));
        list.add(new Student("李四",18));
        list.add(new Student("王五",19));
        list.add(new Student("赵六",25));
        list.add(new Student("前妻",27));
        list.add(new Student("王炸",28));
        list.add(new Student("小王",26));
        list.add(new Student("大王",24));
        list.add(new Student("蘑菇头",23));
        list.add(new Student("妹爷",29));
        list.add(new Student("老王",30));
        list.add(new Student("老李",22));

        //3.使用Stream流过滤集合中年龄>20的元素
        //4.截取前面的8个元素
        //5.跳过前面的2个元素
        //6.把Stream流中剩余的元素回收到list集合
        //7.遍历打印list集合中的学生对象
         list = list.stream().filter(s -> s.getAge() > 20)
                 .limit(8).skip(2).collect(Collectors.toList());

         list.forEach(System.out::println);
    }
}
