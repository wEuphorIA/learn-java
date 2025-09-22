package com.itheima.d4_io.d1_byteio;

/*
  目标：掌握资源释放的两种方式：
       方式一：掌握try-catch-finally资源释放的使用
           try{
               ...
           }catch(Exception){
 
           }finally{
 
           }
           finally：放在try-catch后面的，无论是正常执行还是异常执行代码，最后一定要执行，除非JVM退出。
           作用：一般用于进行最后的资源释放操作（专业级做法）
       方式二：掌握try-with-resource资源释放的使用
           try(创建资源对象){
               ...
           }catch(Exception){
 
           }
           JDK7改进方案：在try后加上小括号，在其内定义流对象，即可自动释放
           注意：资源都是实现了Closeable/AutoCloseable接口的类对象
  需求：硬盘中某个文件复制到当前模块下,文件名保持不变，使用上述两种方式释放资源
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {

    }
}
