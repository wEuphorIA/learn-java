package com.itheima.d1_exception;

/*
    目标：认识自定义异常-运行时异常
    需求:写一个saveAge(int age)方法，在方法中对参数age进行判断，如果age<0或者>=150就认为年龄不合法，
        如果年龄不合法，就告知调用者(通过自定义异常类，把非法年龄告知调用者)
    自定义运行时异常
        1、维承RuntimeException做爸爸。
        2、重写构造器。
        3、通过throw new异常类（xxx）创建异常对象并抛出
    运行时异常特点:编译阶段不报错，运行时才可能出现！提醒不属于激进型。可以处理也可以不处理
 */
public class Demo4 {
    public static void main(String[] args) {
        saveAge(-10);
    }
    public static void saveAge(int age) {
        if (age < 0 || age >= 150) {
            throw new ItheimaAgeIllegalRuntimeException("年龄不合法！");
        }
        System.out.println("保存年龄成功！");
    }
}
