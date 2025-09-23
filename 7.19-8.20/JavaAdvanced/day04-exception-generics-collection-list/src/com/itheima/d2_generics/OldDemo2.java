package com.itheima.d2_generics;

import java.util.ArrayList;

public class OldDemo2 {
    /*
        目标: 清楚泛型和集合不支持基本数据类型，只能支持对象类型（引用数据类型）。
        泛型擦除：泛型工作在编译阶段，等编译后泛型就没用了，所以泛型在编译后都会被擦除。所有类型会恢复成Object类型
        包装类: 8种，int->Integer，char->Character，其他的都是基本类型首字母大写
        手动装箱: 借助包装类提供的API方法, 包装类.valueOf(参数)
        自动装箱：基本数据类型的数据可以直接变成包装对象的数据，不需要额外做任何事情
        自动拆箱：把包装类型的对象直接给基本类型的数据
        保障类的常用API: ① 把基本类型的数据转换成字符串。  toString
                       ② 字符串数值转换成对应的基本数据类型（很有用）。 parseInt  valueOf
     */
    public static void main(String[] args) {
        // 目标：搞清楚泛型和集合不支持基本数据类型，只能支持对象类型（引用数据类型）。
        // ArrayList<int> list = new ArrayList<>();
        // 泛型擦除：泛型工作在编译阶段，等编译后泛型就没用了，所以泛型在编译后都会被擦除。所有类型会恢复成Object类型

        // 把基本数据类型变成包装类对象。
        // 手工包装:
        // Integer i = new Integer(100); // 过时
        Integer it1 = Integer.valueOf(100);  // 推荐的
        Integer it2 = Integer.valueOf(100);  // 推荐的
        System.out.println(it1 == it2);

        // 自动装箱成对象：基本数据类型的数据可以直接变成包装对象的数据，不需要额外做任何事情
        Integer it11 = 130;
        Integer it22 = 130;
        System.out.println(it11 == it22);

        // 自动拆箱：把包装类型的对象直接给基本类型的数据
        int i = it11;
        System.out.println(i);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(130);  // 自动装箱
        list.add(120);  // 自动装箱
        int rs = list.get(1); // 自动拆箱

        System.out.println("-----------------------------------------------------------------------");
        // 包装类新增的功能：
        // 1、把基本类型的数据转换成字符串。
        int j = 23;
        String rs1 = Integer.toString(j);   // "23"
        System.out.println(rs1 + 1); // 231

        Integer i2 = j;
        String rs2 = i2.toString(); // "23"
        System.out.println(rs2 + 1 ); // 231

        String rs3 = j + "";
        System.out.println(rs3 + 1 ); // 231

        System.out.println("-----------------------------------------------------------------------");

        // 2、把字符串数值转换成对应的基本数据类型（很有用）。
        String str = "98";
        // int i1 = Integer.parseInt(str);
        int i1 = Integer.valueOf(str);
        System.out.println(i1 + 2);

        String str2 = "98.8";
//        double d = Double.parseDouble(str2);
        double d = Double.valueOf(str2);
        System.out.println(d + 2);
    }
}
