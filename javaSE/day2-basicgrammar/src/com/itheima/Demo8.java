package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午4:57
 */
/*
    关键字：Java自身用到的一些具有特殊含义的英语单词。例如：public、class、int、long、double...
    标识符：给包、类、变量等取的名字
        规则：
            1、一般由数字、字母、下划线(_)和美元符($)等组成
            2、不能以数字开头，不能是关键字，不能包含一些特殊字符(&、%、#...)
            3、变量名：建议首字母小写，后面每个单词首字母大写，满足"小驼峰模式"
                小驼峰模式：当名称由多个单词构成时，第一个单词首字母小写，后面每个单词首字母大写。
            4、类名：建议所有单词首字母都大写，满足"大驼峰模式"
                大驼峰模式：：当名称由多个单词构成时，每个单词首字母都大写。
 */
public class Demo8 {
    public static void main(String[] args) {

        //1、一般由数字、字母、下划线(_)和美元符($)等组成
        int a1 = 10;
        int b_ = 20;
        int $c = 30;
        System.out.println(a1);
        System.out.println(b_);
        System.out.println($c);

        //2、不能以数字开头，不能是关键字，不能包含一些特殊字符(&、%、#...)
        // int 1a = 10;
        // int if = 20;
        // int a& = 30;

        //3、变量名：建议首字母小写，后面每个单词首字母大写，满足"小驼峰模式"
        int studentAge = 10;
        System.out.println(studentAge);
    }
}
