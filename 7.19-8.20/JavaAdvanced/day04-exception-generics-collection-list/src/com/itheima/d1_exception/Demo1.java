package com.itheima.d1_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    目标：认识异常->异常的继承体系和处理方式
    异常分类：
        运行时异常：RuntimeException及其子类异常，编译不报错，运行时才可能报错。
        编译时异常：编译时有错误提示，必须处理，否则无法通过编译。
    异常的处理方式
    1、抛出异常（）
        在方法上使用throws关键字把方法内部出现的异常抛出去给调用者处理。如果所有调用者都抛出异常，
        异常最终会被JVM处理，程序终止。。
        方法(参数列表) throws 异常1 ，异常2 ，异常3 ..{
          …
        }
    2、捕获异常(try…catch)
        一旦使用try…catch捕获了异常，也就意味着处理了异常，程序不会终止。
        try{
           // 监视可能出现异常的代码！
           }catch(异常类型1 变量){
              // 处理异常
          }catch(异常类型2 变量){
             // 处理异常
         }...
 */
public class Demo1 {
    public static void main(String[] args){
        //1 演示一个运行时异常：打印输出数组中索引为3的元素
        // show();

        //2 演示一个编译时异常：使用SimpleDateFormat格式化器对象解析日期时间字符串得到Date对象
        try {
            show2();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void show(){
        //1 演示一个运行时异常：打印输出数组中索引为3的元素
        //特点：运行时异常，编译器不检查，运行时检查。运行时出错，程序结束
        System.out.println("show方法开始执行...");
        int[] arr = {10,20,30};
        System.out.println(arr[3]);
        System.out.println("后续代码");
    }
    public static void show2() throws ParseException {
        //2 演示一个编译时异常：使用SimpleDateFormat格式化器对象解析日期时间字符串得到Date对象
        // 特点：编译期间直接爆红，必须要处理异常
        System.out.println("show2方法开始执行...");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2099-10-10 :10:10");
        System.out.println("date = " + date);
        System.out.println("后续代码");
    }

}
