package com.itheima.d4_collections;

/*
     目标：认识可变参数，掌握其作用。

        可变参数 : 就是一种特殊形参，定义在方法、构造器的形参列表里，格式是：数据类型...参数名称；
        特点：可以不传数据给它；可以传一个或者同时传多个数据给它；也可以传一个数组给它。
        好处：常常用来灵活地接收数据。

        注意事项 :
            1 可变参数在方法内部就是一个数组。
            2 一个形参列表中可变参数只能有一个
            3 可变参数必须放在形参列表的最后面
 */
public class Demo1 {
    public static void main(String[] args) {

        System.out.println(sum(1));
        System.out.println(sum(1,2));
        System.out.println(sum(1,2,3));
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}));

    }
    /*
        需求：定义一个方法，可以求任意几个整数的和
        举例：
            传递给方法一个整数，则和就是这个整数
            传递给方法两个整数，则求这两个整数的和
            传递给方法三个整数，则求这三个整数的和
            传递给方法一个数组，则求数组中元素的和
         */
    public static int sum(int...args){
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
}
