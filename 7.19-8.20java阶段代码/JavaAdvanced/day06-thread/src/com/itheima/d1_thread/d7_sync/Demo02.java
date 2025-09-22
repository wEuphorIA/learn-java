package com.itheima.d1_thread.d7_sync;

//目标：掌握使用同步方法的方式给线程代码上锁
public class Demo02 {
    public static void main(String[] args) {
        /**
         * 同步方法其实底层也是有隐式锁对象的，只是锁的范围是整个方法代码
         *
         * 格式：
         *      修饰符 synchronized 返回值类型 方法名称(形参列表) {
         *              操作共享资源的代码
         *      }
         *
         * 如果方法是实例方法：同步方法默认用this作为的锁对象
         * 如果方法是静态方法：同步方法默认用类名.class作为的锁对象
         *
         * 需求：使用同步方法改进火车站售票案例
         */
    }
}
