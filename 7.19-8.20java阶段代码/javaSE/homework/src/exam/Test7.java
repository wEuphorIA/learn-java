package exam;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午4:41 */
public class Test7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
