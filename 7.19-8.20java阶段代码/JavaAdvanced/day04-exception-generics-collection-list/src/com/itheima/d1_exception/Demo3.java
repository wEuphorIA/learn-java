package com.itheima.d1_exception;

/*
目标：认识自定义异常-编译时异常
需求:写一个saveAge(int age)方法，在方法中对参数age进行判断，如果age<0或者>=150就认为年龄不合法，
    如果年龄不合法，就告知调用者(通过自定义异常类，把非法年龄告知调用者)
    自定义编译时异常
        1、维承Exception做爸爸。
        2、重写构造器。
        3、通过throw new异常类（xxx）创建异常对象并抛出
    编译时异常特点:编译阶段就报错，提醒比较激进;必须要处理，要么try...catch，要么throws
 */
public class Demo3 {
    public static void main(String[] args) {
        try {
            saveAge(-10);
        } catch (ItheimaAgeIllegalException e) {
           e.printStackTrace();
        }
    }
    //3、通过throw new异常类（xxx）创建异常对象并抛出
    public static void saveAge(int age) throws ItheimaAgeIllegalException {
        if (age < 0 || age >= 150) {
            // 创建异常对象 抛出异常对象
            throw  new ItheimaAgeIllegalException("年龄不合法！");

        }
        System.out.println("保存年龄成功！");
    }
}
