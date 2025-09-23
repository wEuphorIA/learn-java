package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:43
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println("请输入姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入身高：");
        double height = sc.nextDouble();
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age + "岁");
        System.out.println("身高：" + height + "米");
    }
}
