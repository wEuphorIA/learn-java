package com.itheima.d1_exception;

/*
目标：异常的处理方式
    1、抛出异常（throws）
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
public class Demo02 {
    public static void main(String[] args) {
        //需求1：调用test1()方法
        test1();
        System.out.println("main方法执行结束...");
    }

    public static void test1() {
        test2();
        System.out.println("test1方法执行结束...");
    }

    public static void test2(){
        System.out.println("test2方法执行结束...");
    }
}
