package day2Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:10
 */
// 需求 :  往ArrayList添加以下元素”abc1”, ”abc2”, ”abc3”, ”abc4”，请使用 4 种遍历方式,  对集合进行遍历
public class Practice1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        // 第一种
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------------");

        // 第二种
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("----------------");

        // 第三种
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("----------------");
        // 第四种
        list.forEach(System.out::println);
    }
}
