package day3_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 上午10:10
 */
public class StudentTest {
    public static void main(String[] args) {
        //准备好一个集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"金毛狮王","周芷若", "周芷若","张无忌","灭绝师太","灭绝师太","张三丰", "张翠山", "小昭", "赵敏");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杨过","小龙女","张三丰", "张翠山", "小昭", "赵敏");

        //1.获取两个集合的流，将两个流合并为一个流
        Stream<String> stream = list1.stream();
        Stream<String> stream1 = list2.stream();
        Stream<String> stream2 = Stream.concat(stream, stream1);

        //2.过滤姓名长度大于2的元素、截取前面8个、跳过前面1个、去重重复元素
        Stream<String> stream3 = stream2.filter(name -> name.length() > 2)
                .limit(8).skip(1).distinct();


        //3 将Stream流中的字符串名字转换成Student对象，对象的年龄取[18,100]之间的随机整数，转换完成之后遍历打印。
        Random random = new Random();
        stream3.map(name -> new Student(name, (random.nextInt(18,101))))
                .forEach(System.out::println);

    }
}
