package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:50
 */
public class Practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        double a = sc.nextDouble();
        System.out.println("请输入第二个数字");
        double b = sc.nextDouble();
        System.out.println("两个数字的和为：" + (a + b));
        System.out.println("两个数字的差为：" + (a - b));
        System.out.println("两个数字的积为：" + (a * b));
        System.out.println("两个数字的商为：" + (a / b));

    }
}
