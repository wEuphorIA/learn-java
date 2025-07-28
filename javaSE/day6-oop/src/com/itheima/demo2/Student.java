package com.itheima.demo2;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 上午11:04
 */
public class Student {
    String name;
    double chinese;
    double math;

    public void printTotal()
    {
        System.out.println(name + "的总成绩为：" + (chinese  + math));
    }

    public void printAverage()
    {
        System.out.println(name + "的平均成绩为：" + ((chinese + math) / 2));
    }
}
