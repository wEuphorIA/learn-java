package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午3:11
 */
/*
    数据类型：规定变量能存储什么类型的数据
    分类：
        基本数据类型：4类8种
            整型
                byte    1个字节    字节型，取值范围-128~127
                short   2个字节    短整型
                int     4个字节    整型，整型的默认类型
                long    8个字节    长整型
            浮点型
                float   4个字节    单精度浮点型
                double  8个字节    双精度浮点型，浮点型的默认类型
            字符型
                char    2个字节    字符型
            布尔型
                boolean 1个字节    布尔型，布尔型只有两个值：true和false
        引用数据类型：数组、对象等。String字符串属于引用类型。
            String name = "张益达";
 */
public class Demo5 {
    public static void main(String[] args) {

        // byte    1个字节    字节型，取值范围-128~127
        byte a = 127;
        System.out.println(a);

        // short   2个字节    短整型
        short b = 32767;
        System.out.println(b);

        // int     4个字节    整型，整型的默认类型
        int c = 2147483647;
        System.out.println(c);

        // long    8个字节    长整型
        long d = 9223372036854775807L;
        System.out.println(d);

        // float   4个字节    单精度浮点型
        float e = 3.14f;
        System.out.println(e);

        // double  8个字节    双精度浮点型，浮点型的默认类型
        double f = 3.14;
        System.out.println(f);

        // char    2个字节    字符型
        char g = 'a';
        System.out.println(g);

        // boolean 1个字节    布尔型，布尔型只有两个值：true和false
        boolean h = true;
        System.out.println(h);

        // String字符串属于引用类型
        String name = "张益达";
        System.out.println(name);
    }
}
