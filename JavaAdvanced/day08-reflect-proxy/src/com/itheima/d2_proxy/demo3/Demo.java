package com.itheima.d2_proxy.demo3;

/**
 需求：
    现有同事已经开发好了用户登录和注册功能：
        已有UserService接口，声明了login()登录、regist()注册方法
        已有UserServiceImpl实现了UserService接口，重写了login()和regist()方法，实现了登录和注册功能,其中：
            登录：输出”登录成功”
            注册：输出”注册成功”
    要求利用动态代理技术，在不改变同事代码的情况下，统计login()方法和regist()方法的执行耗时：
 分析
    1 创建UserServiceImpl目标对象
    2 使用Proxy.newProxyInstance()为目标对象创建代理对象
    3 在InvocationHandler的invoke方法中定义代理规则
    4 调用代理对象的login()和regist()方法
 */
public class Demo {
    public static void main(String[] args) {

    }
}
