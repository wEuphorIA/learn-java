/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 下午6:28 */
//求阶乘
public class Factorial {
    public static void main(String[] args) {
        System.out.println(f(5));
    }
    public static int f(int n){
        if (n == 1) return 1;
        return n * f(n-1);
    }
}
