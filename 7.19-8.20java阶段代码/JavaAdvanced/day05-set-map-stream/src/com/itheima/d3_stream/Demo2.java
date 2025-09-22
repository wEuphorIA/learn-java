package com.itheima.d3_stream;

import java.util.*;
import java.util.stream.Stream;

/*
    目标：Stream流的获取方法
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1、如何获取List集合的Stream流？
        System.out.println("1 -------------------------");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰","张无忌","周芷若","赵敏","张强");

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);


        // 2、如何获取Set集合的Stream流？
        System.out.println("2 -------------------------");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "刘德华","张曼玉","蜘蛛精","马德","德玛西亚");

        Stream<String> stream1 = set.stream();
        stream1.forEach(System.out::println);


        // 3、如何获取Map集合的Stream流？
        System.out.println("3 -------------------------");
        Map<String, Double> map = new HashMap<>();
        map.put("古力娜扎", 172.3);
        map.put("迪丽热巴", 168.3);
        map.put("马尔扎哈", 166.3);
        map.put("卡尔扎巴", 168.3);

        Stream<String> stream2 = map.keySet().stream();
        stream2.forEach(System.out::println);

        // 4、如何获取数组的Stream流？
        System.out.println("4 -------------------------");
        String[] arr = {"张翠山", "东方不败", "唐大山", "独孤求败"};

        Stream<String> stream3 = Arrays.stream(arr);
        stream3.forEach(System.out::println);
        System.out.println("5 -------------------------");
        Stream<String> stream4 = Stream.of(arr);
        stream4.forEach(System.out::println);
    }
}
