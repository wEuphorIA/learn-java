package com.itheima.date;

import java.util.Date;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午3:09
 */
/*
目标：Date类构造方法和成员方法演示
    构造方法：
        public Date()   创建Date对象，代表系统当前日期时间
        public Date(long time)  创建Date对象，代表自1970年1月1日以来的日期时间
    成员方法：
        public long getTime()   返回从1970年1月1日 0时0分0秒以来的毫秒值
        public void setTime(long time)   设置Date对象自1970年1月1日 0时0分0秒以来的毫秒值
 */
public class Demo1 {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        long time = date.getTime();
        System.out.println(time);

        date.setTime(time);
        System.out.println(date);


        Date date1 = new Date(1000);
        System.out.println(date1);
    }
}
