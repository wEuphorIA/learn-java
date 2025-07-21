import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个以秒为单位的时间大小：");
        int number = scanner.nextInt();
        int a = number % 3600 / 60;
        int b = number % 60;
        int c = number / 3600;
        System.out.println(c + ":" + a + ":" + b);
    }
}