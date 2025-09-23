package com.itheima.d1_api;

/*
目标：JDK8日期类LocalDateTime、LocalDate、LocalTime常用方法
 */
public class Demo03 {
    public static void main(String[] args) {
        // 1、获取本地当前日期和时间对象。
        System.out.println("1、---------------------");

        // 2、获取本地指定日期和时间对象：2029年12月12日12时12分12秒
        System.out.println("2、---------------------");


        // 3、可以获取日期和时间的全部信息（年、月、日、时、分、秒、年中的天、星期几）
        System.out.println("3、---------------------");

        // 4、修改时间信息：withYear withMonth withDayOfMonth withDayOfYear withHour withMinute withSecond withNano
        System.out.println("4、---------------------");

        // 5、加多少: plusYears  plusMonths plusDays plusWeeks plusHours plusMinutes plusSeconds plusNanos
        System.out.println("5、---------------------");

        // 6、减多少：minusDays minusYears minusMonths minusWeeks minusHours minusMinutes minusSeconds minusNanos
        System.out.println("6、---------------------");

        // 7、 判断2个日期、时间对象，所表示的时间是否相等，在前还是在后： equals、isBefore、isAfter
        System.out.println("7、---------------------");

        // 8、可以把LocalDateTime转换成LocalDate和LocalTime
        System.out.println("8、---------------------");
    }
}
