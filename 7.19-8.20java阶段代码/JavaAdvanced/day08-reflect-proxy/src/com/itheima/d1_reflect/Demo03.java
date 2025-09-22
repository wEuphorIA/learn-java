package com.itheima.d1_reflect;

//目标：掌握利用反射获取成员变量Field对象
/**
 * 需求：获取Student类中的各个属性Field对象，并给属性赋值、获取属性的值
 * 获取成员变量的方法：
 *      Field[] getFields()：返回所有成员变量对象的数组（只能拿public的）
 *      Field[] getDeclaredFields()：返回所有成员变量对象的数组，存在就能拿到
 *      Field getField(String name)：返回单个成员变量对象（只能拿public的）
 *      Field getDeclaredField(String name)：返回单个成员变量对象，存在就能拿到
 *
 * Field类中用于取值、赋值的方法：
 *      void set(Object obj, Object value)：赋值
 *      Object get(Object obj)：获取值
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {

    }
}
