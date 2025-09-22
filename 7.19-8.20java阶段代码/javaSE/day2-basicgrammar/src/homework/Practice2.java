package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:45
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个小数");
        double number = scanner.nextDouble();
        System.out.println("原始小数是：" + number);
        //System.out.println("四舍五入后取整是：" + Math.round(number));
        System.out.println("四舍五入后取整是：" +  (int) (number + 0.5));
    }
}