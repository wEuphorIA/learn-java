package day05.stream.practice5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午8:14 */
public class Practice5 {
    public static void main(String[] args) {
        //准备好一个集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"金毛狮王","周芷若", "周芷若","张无忌","灭绝师太","灭绝师太","张三丰", "张翠山", "小昭", "赵敏");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杨过","小龙女","张三丰", "张翠山", "小昭", "赵敏");

        //1.获取两个集合的流，将两个流合并为一个流
        Stream<String> concat = Stream.concat(list1.stream(), list2.stream());

        //2.过滤姓名长度大于2的元素、截取前面8个、跳过前面1个、去重重复元素
        Random random = new Random();
        concat.filter(s -> s.length() > 2).limit(8).skip(1).distinct().map(name -> new Student( name,random.nextInt(18,101))).forEach(System.out::println);
        //3 将Stream流中的字符串名字转换成Student对象，对象的年龄取[18,100]之间的随机整数，转换完成之后遍历打印。
    }
}
