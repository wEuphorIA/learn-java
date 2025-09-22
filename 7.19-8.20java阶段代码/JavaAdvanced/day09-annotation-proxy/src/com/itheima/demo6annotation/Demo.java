package com.itheima.demo6annotation;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/19 上午11:51 */
@MyTest(value = "张三",bbb = {"张三","张三"})
public class Demo {

    @MyTest(value = "李四",aaa = 99,bbb = {"北京","上海"})
    public void test1(){

    }
}
