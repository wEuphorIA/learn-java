package com.itheima.d1_reflect;

//目标：掌握利用反射获取构造器Constructor对象
/**
 * 需求：利用反射获取Student类的构造器对象，并利用构造器对象创建Student对象
 * 获取构造器的方法：
 *      Constructor<?>[] getConstructors()：返回所有构造器对象的数组（只能拿public的）
 *      Constructor<?>[] getDeclaredConstructors()：返回所有构造器对象的数组，存在就能拿到
 *      Constructor<T> getConstructor(Class<?>... parameterTypes)：返回单个构造器对象（只能拿public的）
 *      Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：返回单个构造器对象，存在就能拿到
 *
 * 创建对象的方法：
 *     // T newInstance(Object... initargs)：根据指定的构造器创建对象
 *      void setAccessible(boolean flag)：设置为true,表示取消访问检查，进行暴力反射
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {

    }
}
