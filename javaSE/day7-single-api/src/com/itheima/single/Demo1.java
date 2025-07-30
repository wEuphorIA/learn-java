package com.itheima.single;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 上午9:14
 */
public class Demo1 {
    public static void main(String[] args) {

        //A a = new A(); 报错说明没办法从外部创建对象
        A a1 = A.getInstance();
        A a2 = A.getInstance();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1==a2);

        B b1 = B.getInstance();
        B b2 = B.getInstance();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1==b2);

        
    }
}
