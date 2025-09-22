package com.itheima;
//第一步：导包，诉程序去JDk的哪个包中找Scanner扫描器。idea可以自动导包。
import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午6:18
 */
/*
    Scanner类：Java给我们提供的扫描器类，需要new这个类的对象（根据图纸生产扫描器对象）才可以使用。
    使用步骤：
        第一步：导包，诉程序去JDk的哪个包中找Scanner扫描器。idea可以自动导包。
        第二步：创建扫描器Scanner对象，会自动导包。
        第三步：用方法等待用户输入不同类型的数据。
 */
public class Demo10 {
    public static void main(String[] args) {

        //第二步：创建扫描器Scanner对象，会自动导包。
        Scanner scanner = new Scanner(System.in);

        //第三步：用方法等待用户输入不同类型的数据。
        System.out.println("请输入一个整数：");
        int a = scanner.nextInt();
        System.out.println("请输入一个字符串：");
        String next = scanner.next();
        System.out.println("输入的值为" +  a +  next);
    }
}
