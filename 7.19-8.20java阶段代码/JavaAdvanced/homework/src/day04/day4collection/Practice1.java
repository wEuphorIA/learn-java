package day04.day4collection;

import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 下午8:19 */
public class Practice1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("learning");
        list.add("Java");
        list.add("at");
        list.add("heima");

        for (int i = 0; i < list.size(); i++) {
            String upperCase = list.get(i).toUpperCase();
            list1.add(upperCase);
        }
        System.out.println(list1);
    }
}
