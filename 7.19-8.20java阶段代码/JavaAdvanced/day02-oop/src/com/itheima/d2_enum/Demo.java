package com.itheima.d2_enum;

import java.util.Arrays;

public class Demo {
    private static final String MAN = "男";
    private static final String WOMAN = "女";

    public static void main(String[] args) {
        // 4 枚举类的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。
        //Gender gender = new Gender(); // 编译报错
        Gender man = Gender.MAN;
        System.out.println(man);  //打印的是枚举对象的名称

        man.setValue("男");
        System.out.println(man.getValue());

        System.out.println("--------------");

        Gender woman = Gender.WOMAN;
        System.out.println(woman); //打印的是枚举对象的名称
        System.out.println(woman.getValue());

        //5 编译器为枚举类新增了几个静态方法，用于获取所有枚举对象或者某个枚举对象。
        Gender[] genders = Gender.values();  //获取所有枚举对象
        System.out.println(Arrays.toString(genders));

        Gender gender = Gender.valueOf("MAN");  //根据名称获取一个枚举对象
        System.out.println("gender = " + gender);

        //调用show方法传递性别
//        show(MAN);
//        show(WOMAN);
//        show("hello");

        show(Gender.MAN);
        show(Gender.WOMAN);
    }


    /*public static void show(String gender) {
        System.out.println(gender);
    }*/

    public static void show(Gender gender) {
        System.out.println(gender);
    }
}
