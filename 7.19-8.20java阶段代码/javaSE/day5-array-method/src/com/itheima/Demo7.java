package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午3:19
 */
/*
    需求：某部门5名员工的销售额分别是：16、26、36、6、100，请定义方法计算出他们部门的销售总额并返回。
    分析：
        参数列表：接收一个整型数组，形参声明为(int[] arr)
        返回值：返回销售总额，因此，返回值类型声明int
        方法内逻辑：
            1 循环外定义求和变量sum，初始值为θ。
            2 遍历数组中的每个元素
            3 将每个元素累加到sum中。
            4 循环结束后返回sum的值。
 */
public class Demo7 {
    public static void main(String[] args) {
        int[] arr = {16,26,36,6,100};
        System.out.println("公司的营业额为：" + sum(arr));
    }
    /** 
     * @Description: 数组求和
     * @param: arr 
     * @return: int 
     * @author Euphoria
     * @date: 2025/7/26 下午3:25
     */ 
    public static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
