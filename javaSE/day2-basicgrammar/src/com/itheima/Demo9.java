package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午5:30
 */
public class Demo9 {
    /*
    debug:通过控制代码一行一行执行，定位和分析代码中存在的错误的一种手段。
    使用步骤：
        第一步：在代码的左侧行号处点一下形成断点。注意不要打在注释行。
        第二步：以debug方式允许程序，程序会停在断点行。
        第三步：控制程序一步一步执行，观察变量的变化情况以及输出的结果。
 */

    public static void main(String[] args) {
        //1 定义double类型变量，初始值为0.1
        double num = 0.1;
        System.out.println(num);    //0.1

        //2 将变量的值加0.1后输出
        num = num + 0.1;
        System.out.println(num);    //0.2

        //3 将变量的值再加.1后输出
        num = num + 0.1;
        System.out.println(num);    //0.3
    }
}


