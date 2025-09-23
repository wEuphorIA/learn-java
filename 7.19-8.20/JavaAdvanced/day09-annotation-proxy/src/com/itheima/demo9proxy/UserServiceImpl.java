package com.itheima.demo9proxy;

/**
 * 用户业务接口的实现类
 *
 * @author alexis
 */
public class UserServiceImpl implements UserService {
    // 用户业务实现类（面向接口编程）
    @Override
    public void login(String loginName, String password) throws InterruptedException {
        long start=System.currentTimeMillis();
        if ("admin".equals(loginName) && "123456".equals(password)) {
            System.out.println("您登录成功，欢迎光临本系统~");
        } else {
            System.out.println("您登录失败，用户名或密码错误~");
        }
        Thread.sleep(1000); //模拟程序的执行耗时
        long end =System.currentTimeMillis();
        System.out.println("Login方法耗时："+(end-start)/1000.0+"秒");
    }

    @Override
    public void deleteUsers() throws InterruptedException {
        long start=System.currentTimeMillis();
        System.out.println("成功删除了1万个用户~");
        Thread.sleep(1500);
        long end=System.currentTimeMillis();
        System.out.println("selectUsers方法耗时："+(end-start)/1000.0+"秒");
    }

    @Override
    public String[] selectUsers() throws InterruptedException {
        long start=System.currentTimeMillis();
        System.out.println("查询出了3个用户");
        String[] names = {"Angelababy", "蔡徐坤", "张歆艺"};
        Thread.sleep(500);
        long end=System.currentTimeMillis();
        System.out.println("selectUsers方法耗时："+(end-start)/1000.0+"秒");
        return names;
    }

}
