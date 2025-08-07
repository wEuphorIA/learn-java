package day03;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 上午12:20 */
public class Practice2 {
    public static void main(String[] args) {

        // 使用Lambda【标准格式】调用invokeCalc方法
        invokeCalc(130, 120, (int a, int b) ->{return a-b;});
        // 使用Lambda【省略格式】调用invokeCalc方法
        invokeCalc(130, 120, (a, b) -> a-b);
    }
    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}

interface Calculator {
    int calc(int a, int b);
}