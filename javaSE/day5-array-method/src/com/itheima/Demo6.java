package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午3:15
 */
/*
    注意事项
        1、一个类中可以定义多个方法，方法在类中的位置放前放后无所谓。
        2、一个方法中也可以调用多个方法，但是不能在方法中定义方法。
        3、return返回的结果要和返回值类型匹配，且return语句的下面不能再编写代码，否则程序会编译报错。
        4、如果方法不需要返回结果，返回值类型必须使用void(表示无返回值)，此时方法内不可以使用return返回数据。
        5、形参列表可以有0个或者多个形参(定义变量)，多个形参必须用","隔开，且不能给初始化值。
 */
public class Demo6 {

    //有参有返回值

    //1、一个类中可以定义多个方法，方法在类中的位置放前放后无所谓。

    public static int getSum(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {

        //2、一个方法中也可以调用多个方法，但是不能在方法中定义方法。
        // 第一个方法
        int sum = getSum(10, 20);
        System.out.println(sum);

        // 第二个方法
        show(4);
    }

    //有参无返回值
    public static void show(int a) {
        System.out.println("这个数是"+a);
    }

    //无参有返回值
    public static String print() {
        return "这个数是";
    }
}
