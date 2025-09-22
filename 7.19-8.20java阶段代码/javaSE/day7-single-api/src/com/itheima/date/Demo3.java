package com.itheima.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
目标：JDK8日期类LocalDateTime、LocalDate、LocalTime常用方法
 */
public class Demo3 {
    public static void main(String[] args) {

        // 1、获取本地当前日期和时间对象。
        System.out.println("1、---------------------");
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDate);

        // 2、获取本地指定日期和时间对象：2029年12月12日12时12分12秒
        System.out.println("2、---------------------");
        LocalDateTime localDateTime1 = LocalDateTime.of(2029, 12, 12, 12, 12, 12);
        System.out.println(localDateTime1);

        // 3、可以获取日期和时间的全部信息（年、月、日、时、分、秒、年中的天、星期几）
        System.out.println("3、---------------------");
        System.out.println("年=" + localDateTime.getYear());
        System.out.println("月=" +localDateTime.getMonth());
        System.out.println("日=" +localDateTime.getDayOfMonth());
        System.out.println("时=" +localDateTime.getHour());
        System.out.println("分=" +localDateTime.getMinute());
        System.out.println("秒=" +localDateTime.getSecond());
        System.out.println("毫秒=" +localDateTime.getNano());
        System.out.println("年中的第几天=" + localDateTime.getDayOfYear());
        System.out.println("星期几=" + localDateTime.getDayOfWeek());

        // 4、修改时间信息：withYear withMonth withDayOfMonth withDayOfYear withHour withMinute withSecond withNano
        System.out.println("4、---------------------");
        System.out.println("修改后的年=" + localDateTime.withYear(2023));
        System.out.println("修改后的月=" + localDateTime.withMonth(12));
        System.out.println("修改后的日=" + localDateTime.withDayOfMonth(25));
        System.out.println("修改后的时=" + localDateTime.withHour(23));
        System.out.println("修改后的分=" + localDateTime.withMinute(59));
        System.out.println("修改后的秒=" + localDateTime.withSecond(59));
        System.out.println("修改后的毫秒=" + localDateTime.withNano(999999999));

        // 5、加多少: plusYears  plusMonths plusDays plusWeeks plusHours plusMinutes plusSeconds plusNanos
        System.out.println("5、---------------------");
        System.out.println("加5年后=" + localDateTime.plusYears(5));
        System.out.println("加5个月后=" + localDateTime.plusMonths(5));

        // 6、减多少：minusDays minusYears minusMonths minusWeeks minusHours minusMinutes minusSeconds minusNanos
        System.out.println("6、---------------------");
        System.out.println("减5年后=" + localDateTime.minusYears(5));

        // 7、 判断2个日期、时间对象，所表示的时间是否相等，在前还是在后： equals、isBefore、isAfter
        System.out.println("7、---------------------");
        System.out.println(localDateTime.isAfter(localDateTime1));
        System.out.println(localDateTime.isBefore(localDateTime1));
        System.out.println(localDateTime.equals(localDateTime1));

        // 8、可以把LocalDateTime转换成LocalDate和LocalTime
        System.out.println("8、---------------------");
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());

    }
}
