package day04.day4collection.Practice3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 下午8:27 */
public class Practice3 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"小亮",99));
        list.add(new Student(2,"小强",85));
        list.add(new Student(3,"小响",90));
        list.add(new Student(4,"小勇",75));

        list.sort((s1, s2)-> s2.getScore() - s1.getScore());
        System.out.println("删除前");
        list.forEach(System.out::println);
        list.remove(list.size()-1);
        System.out.println("录取的人为");
        list.forEach(System.out::println);
    }
}
