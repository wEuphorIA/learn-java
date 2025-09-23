package com.itheima.d5_demo;

import java.util.Scanner;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午5:46 */
public class Demo1 {
    // 1.每一个设备都需要一个开关的功能,所以定义一个接口,写一个抽象的开关功能
    // 2.定义一个JD抽象类,封装了JD设备中的共有属性和共有方法
    // 3. 定义TV WashMachine Air Lamp等类,继承JD的抽象父类
    // 4. 定义一个JD数组,存储多个设备
    // 5.把所有设备交给智能管理系统来控制，所以要定义一个智能管理系统的类, 智能管理系统智能被创建一次，所以用单例设计模式来优化
    public static void main(String[] args) {
        SmartHomeControl shc = SmartHomeControl.getInstance();
        JD[] jds = new JD[4];
        jds[0] = new TV("TCL电视", false);
        jds[1] = new WashMachine("美的洗衣机", true);
        jds[2] = new Air("小米空调", false);
        jds[3] = new Lamp("飞利浦电灯", true);

        while (true) {
            shc.printAllJD(jds);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入操作设备：" + jds[0].getName() + " " + jds[1].getName() + " " + jds[2].getName() + " " + jds[3].getName());
            System.out.println("====================================");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    shc.control(jds[0]);
                    break;
                case 2:
                    shc.control(jds[1]);
                    break;
                case 3:
                    shc.control(jds[2]);
                    break;
                case 4:
                    shc.control(jds[3]);
                    break;
                default:
                    System.out.println("输入错误！");
                    return;
            }
        }
    }
}
