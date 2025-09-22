package com.itheima.d1_network.demo9;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Demo1Date {
    public static void main(String[] args) {
        //目标：掌握Java中的日期时间类的使用
        //jdk1.7之前的日期时间类(不推荐使用,了解即可)
        Date date = new Date();
        System.out.println(date);
        // 日期格式化为一个好看的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        System.out.println(time);

        System.out.println("-----------------------------------------");

        // jdk1.8之后的日期时间类(推荐使用)
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //演示LocalDateTime中的常用方法
        //获取年
        System.out.println(now.getYear());
        //获取月
        System.out.println(now.getMonthValue());
        //获取日
        System.out.println(now.getDayOfMonth());
        //获取时
        System.out.println(now.getHour());

        System.out.println("=========================================");

        //演示日期时间的增和减
        LocalDateTime localDateTime = now.plusYears(2).plusMonths(3).plusDays(4).plusHours(5).plusMinutes(6).plusSeconds(7);
        System.out.println(localDateTime);

        //获取上个月的时间
        LocalDateTime localDateTime1 = now.minusMonths(1);
        System.out.println(localDateTime1);

        System.out.println(now.isAfter(localDateTime1));
        System.out.println(now.isBefore(localDateTime1));

        System.out.println("=========================================");
        LocalDateTime now2 = LocalDateTime.now();
        //格式化
        String format = now2.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
        System.out.println(format);
    }
}
