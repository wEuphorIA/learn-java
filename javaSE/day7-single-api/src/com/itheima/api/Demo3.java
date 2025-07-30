package com.itheima.api;

import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午12:02
 */
/*
    案例：随机验证码
    需求：定义方法实现随机产生n位验证码，验证码的每位可能是数字、大写字母、小写字母。
    方法内逻辑：
        //1 定义变量，保存验证码需要用到的θ~9，A~Z，a~z字符。定义变量code保存生成的验证码内容
        //2 for循环n次，每次随机一个不超出字符串长度的索引
        //3 根据索引提取该字符，把该字符交给code变量连接起来
        //4 循环结束后返回code即可。
 */
public class Demo3 {
    public static void main(String[] args) {
        String code = getCode(4);
        System.out.println("code = " + code);
        code = getCode(5);
        System.out.println("code = " + code);
    }

    public static String getCode(int n) {
        //1 定义变量，保存验证码需要用到的θ~9，A~Z，a~z字符。定义变量code保存生成的验证码内容
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String code = "";
        //2 for循环n次，每次随机一个不超出字符串长度的索引
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            //3 根据索引提取该字符，把该字符交给code变量连接起来
            int i1 = r.nextInt(s.length());
            code += s.charAt(i1);
        }
        //4 循环结束后返回code即可。
        return code;
    }
}
