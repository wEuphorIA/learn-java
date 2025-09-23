package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:54
 */
public class Practice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        double result = (number >= 100000) ? number * 0.1 : number * 0.05;
        System.out.println("结果是：" + result);

    }
}
