package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午12:20
 */
/*
    方法：方法是一种语法结构，它可以把一段代码封装成一个功能，以便重复使用。
    定义方法语法：
        修饰符 返回值类型 方法名称(参数列表){
            方法体代码(方法内要做的事);
            return 结果;
        }
        修饰符：定义访问权限，目前固定写成public static后期详细讲解。
        返回值类型：定义方法返回的结果的类型，如果无返回值使用void关键字。
        方法名：方法的名字，小驼峰规则，一定要见名知意。
        参数列表：定义方法中要用的变量，格式是：(数据类型 变量名,数据类型 变量名,...)。

        建议做法：将main方法复制一份，修改 返回值类型 方法名称 参数列表

    方法的4种定义形式：
        有参有返回值、有参无返回值、无参有返回值、无参无返回值

    调用方法语法：
        有返回值的方法：  数据类型 变量名 = 方法名(参数值);
        无返回值的方法：  方法名(参数值);
 */
public class Demo5 {
    public static void main(String[] args) {
        //有返回值的方法：  数据类型 变量名 = 方法名(参数值);
        int sum = getSum(10, 20);
        System.out.println(sum);

        //无返回值的方法：  方法名(参数值);
        show(4);

        String s = print();
        System.out.println(s);

        print1();
    }
    //有参有返回值
    public static int getSum(int a, int b) {
        return a + b;
    }

    //有参无返回值
    public static void show(int a) {
        System.out.println("这个数是"+a);
    }

    //无参有返回值
    public static String print() {
        return "这个数是";
    }

    //无参无返回值
    public static void print1() {
        System.out.println("无参无返回值");
    }
}
