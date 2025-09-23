package com.itheima.d1_reflect;

//目标：掌握利用反射获取方法Method对象
/**
 * 需求：获取Student类中的各个方法Method对象，并且调用方法
 * 获取成员方法的api：
 *      Method[] getMethods()：返回所有成员方法对象的数组（只能拿public的）
 *      Method[] getDeclaredMethods()：返回所有成员方法对象的数组，存在就能拿到
 *      Method getMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象（只能拿public的）
 *      Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象，存在就能拿到
 *
 * 触发执行的方法：
 *      Object invoke(Object obj, Object... args)
 *              运行方法
 *              参数一：用obj对象调用该方法
 *              参数二：调用方法的传递的参数（如果没有就不写）
 *              返回值：方法的返回值（如果没有就不写）
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {

    }
}
