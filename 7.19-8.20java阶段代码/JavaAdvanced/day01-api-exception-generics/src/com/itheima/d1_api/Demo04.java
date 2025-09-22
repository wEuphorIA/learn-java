package com.itheima.d1_api;

/*
    目标：掌握日期格式器DateTimeFormatter的使用
    1 常见日期格式：
        yyyy年MM月dd日 HH时mm分ss秒
        yyyy-MM-dd HH:mm:ss
    2 获取DateTimeFormatter格式化器：
       public static DateTimeFormatter ofPattern(时间模式/格式)
    3 LocalDateTime提供的格式化、解析时间的方法：
        public String format(DateTimeFormatter formatter)：格式化时间
        public static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter)：解析时间
 */
public class Demo04 {
    public static void main(String[] args) {
        // 1、创建一个DateTimeFormatter格式化器对象，指定格式为"yyyy年MM月dd日 HH:mm:ss"
        System.out.println("1、-----------------------");

        // 2、对时间进行格式化
        System.out.println("2、-----------------------");

        // 3、解析时间：将"2029年12月12日 12:12:11"解析为LocalDateTime对象
        System.out.println("3、-----------------------");

    }
}
