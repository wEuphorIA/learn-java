package homework;

import jdk.jfr.DataAmount;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午10:35
 */

public class Practice1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int number1 = scanner.nextInt();
        System.out.println("请输入第二个数字：");
        int number2 = scanner.nextInt();
        System.out.println("请输入一个数字：");
        int number3 = scanner.nextInt();
        if (number1 > number2) {
            if (number1 > number3){
                System.out.println("最大值是：" + number1);
            }else {
                System.out.println("最大值是：" + number3);
            }
        }else {
            if (number2 > number3){
                System.out.println("最大值是：" + number2);
            }else {
                System.out.println("最大值是：" + number3);
            }
        }
    }
}
