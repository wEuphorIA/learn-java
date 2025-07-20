import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数字：");
        System.out.print("数字1：");
        double a = scanner.nextDouble();
        System.out.print("数字2：");
        double b = scanner.nextDouble();
        double result = a / b;
        System.out.println(a + " / " + b + " = " + result);
    }
}