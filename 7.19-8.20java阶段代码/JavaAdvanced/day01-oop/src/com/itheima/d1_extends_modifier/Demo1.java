package com.itheima.d1_extends_modifier;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午4:00 */
public class Demo1 {
    public static void main(String[] args) {
        Fu f = new Fu();
        // f.privateMethod();
        f.defaultMethod();
        f.protectedMethod();
        f.publicMethod();
    }
}
