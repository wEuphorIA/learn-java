package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午3:54
 */
/*
    自动类型转换：
        类型范围小的变量/数据值 可以 直接赋值给类型范围大的变量存储。
        byte-->short-->int-->long-->float-->double
                char-->int-->long-->float-->double
        表达式中的自动类型转换
            byte、short、char-->int-->long-->float-->double
            注意1：在表达式中，byte、short、char是直接转换成int类型参与运算的。
            注意2：表达式的最终结果类型由表达式中的最高类型决定。
        快捷键：  表达式.var+回车，  生成表达式等号左边的变量。例如  x+y.var+回车--->生成int z =x + y
 */
public class Demo6 {
    public static void main(String[] args) {

        //byte-->short-->int-->long-->float-->double
        byte a = 10;
        short b = a;
        System.out.println(b);

        //char-->int-->long-->float-->double
        char c = 'a';
        int d = c;
        System.out.println(d);

        //注意1：在表达式中，byte、short、char是直接转换成int类型参与运算的。
        byte x = 10;
        byte y = 20;
        int i = x + y;
        System.out.println(i);


        //注意2：表达式的最终结果类型由表达式中的最高类型决定。
        byte x1 = 10;
        double y1 = 20;
        double v = x1 + y1;
        System.out.println(v);

    }
}
