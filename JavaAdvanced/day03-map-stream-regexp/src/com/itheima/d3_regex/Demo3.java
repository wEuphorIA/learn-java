package com.itheima.d3_regex;

/*
目标：正则表达式综合案例
需求1：使用正则表达式，校验电话号码（手机|座机）是否合法
      比如：18676769999、010-34242424、0713-3121699、01034242424、07133121699都是合法的
      正则表达式：(1[3-9]\d{9})|(0\d{2}-?\d{8})|(0\d{3}-?\d{7})

需求2：使用正则表达式，校验邮箱账号是否合法
      比如：itheima0009@163.com、itheima@itcast.com.cn、25143242@qq.com 都是合法的
      正则表达式：\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(checkNumber("12012341234")); //false
        System.out.println(checkNumber("15512341234")); //true
        System.out.println(checkNumber("010-34242424")); //true
        System.out.println(checkNumber("010-3422424")); //false
        System.out.println(checkNumber("01053422424")); //true
        System.out.println("--------------");
        System.out.println(checkEmail("abc@163.com"));  //true
        System.out.println(checkEmail("abc163.com"));  //false
        System.out.println(checkEmail("abc@163"));  //false
    }

    /*
    需求1：使用正则表达式，校验电话号码（手机|座机）是否合法
      比如：18676769999、010-34242424、0713-3121699、01034242424、07133121699都是合法的
     */
    public static boolean checkNumber(String tel) {
        return false;
    }

    /*
    需求2：使用正则表达式，校验邮箱账号是否合法
      比如：itheima0009@163.com、itheima@itcast.com.cn、25143242@qq.com 都是合法的
     */
    public static boolean checkEmail(String email) {
        return false;
    }
}
