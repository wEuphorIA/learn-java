package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:50
 */
public class Practice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入摄氏温度");
        double a = sc.nextDouble();
        System.out.println("转换后的华氏温度为：" + (a * 1.8 + 32));
    }
}
