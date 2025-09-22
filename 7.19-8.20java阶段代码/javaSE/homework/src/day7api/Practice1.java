package day7api;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午6:09
 */
public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个生日格式（yyyy-MM-dd)：");
        String birthday = scanner.next();

        // 截取
        int i = birthday.indexOf("-");
        int j = birthday.lastIndexOf("-");

        String year = birthday.substring(0,i);
        System.out.println("年：" + year);

        String month = birthday.substring(i+1,j);
        System.out.println("月：" + month);

        String day = birthday.substring(j+1);
        System.out.println("日：" + day);
    }
}
