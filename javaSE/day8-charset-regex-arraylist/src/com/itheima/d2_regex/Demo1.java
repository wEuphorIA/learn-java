package com.itheima.d2_regex;

/*
    目标：体验正则表达式月传统方式，
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(checkQQ("123abc"));
        System.out.println(checkQQ("0123"));
        System.out.println(checkQQ("123"));
        System.out.println(checkQQ("1234567"));
        System.out.println("---------------------");
        System.out.println(checkQQByRegExp("123abc"));
        System.out.println(checkQQByRegExp("0123"));
        System.out.println(checkQQByRegExp("123"));
        System.out.println(checkQQByRegExp("1234567"));
    }

    /*
        在下面方法中使用传统方式，校验qq号码是否符合要求
        1、判断qq号码是否为null,不是以0开头的，满足6-20之间的长度,
        2、必须全部是数字。
        如果满足条件，返回true; 否则返回false
     */
    public static boolean checkQQ(String qq){
        if(qq==null){
            return false;  //为null、就返回false表示不合法
        }
        if(qq.startsWith("0") || qq.length()<6 || qq.length()>20){
            return false;  //不满足要求
        }
        for (int i = 0; i < qq.length(); i++) {
            char ch = qq.charAt(i);
            if(ch<'0' || ch>'9'){
                return false;
            }
        }
        return true;  //符合要求
    }

    /*
        在下面方法中使用传统方式，校验qq号码是否符合要求
        1、判断qq号码是否为null,不是以0开头的，满足6-20之间的长度,
        2、必须全部是数字。
        如果满足条件，返回true; 否则返回false
     */
    public static boolean checkQQByRegExp(String qq){
        return qq!=null&&qq.matches("[1-9]\\d{5,19}");
    }
}
