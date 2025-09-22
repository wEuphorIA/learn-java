package com.itheima.d2_proxy.demo3;

//用户管理，实现具体的登录和注册操作
public class UserServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("登录成功");
    }

    @Override
    public void regist() {
        System.out.println("注册成功");
    }
}
