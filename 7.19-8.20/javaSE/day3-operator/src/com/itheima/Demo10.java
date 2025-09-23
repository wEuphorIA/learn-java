package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午5:04
 */
/*
    健康计算器
    需求：BMI（Body Mass Index，身体质量指数）是用来评估体重是否适宜的一个常用指标。它通过体重（以干克为单位）除以身高(以米为单位）的平方来计算。BMI的正常范围通常定义为18.5到24.9（kg/m²）。具体来说:
        BMI小于18.5被认为是体重过低;
        BMI在18.5到24.9之间被认为是正常范围;
        BMI在18.5到25(不包括)之间被认为是正常范围;
        BMI在25到30(不包括)之间被认为是超重;
      请键盘录入人的体重和身高，计算并输出他的体重是过低、正常、超重还是肥胖。
    考查技术点：键盘录入、算术运算符、三元运算符的使用。
    步骤：
        //1 创建Scanner扫描器对象
        //2 提示并获取用户输入的体重和身高
        //3 计算BMI身体质量指数。bmi=体重/(身高*身高)
        //4 判断用户的体重是过低、正常、超重还是肥胖。
        //5 输出结果
 */
public class Demo10 {
    public static void main(String[] args) {

        //1 创建Scanner扫描器对象
        Scanner scanner = new Scanner(System.in);
        //2 提示并获取用户输入的体重和身高
        System.out.println("请输入体重：");
        double weight = scanner.nextDouble();
        System.out.println("请输入身高：");
        double height = scanner.nextDouble();

        //3 计算BMI身体质量指数。bmi=体重/(身高*身高)
        double bmi = weight/(height*height);
        System.out.println("bmi的值为" + bmi);

        //4 判断用户的体重是过低、正常、超重还是肥胖。
        String result = bmi <18.5 ? "体重过轻" :  bmi >= 18.5 && bmi < 25 ? "体重正常" :bmi >= 25 && bmi < 30 ? "体重超重" :  "体重肥胖" ;

        System.out.println("你的状况为" + result);
    }
}
