package com.itheima.d4_io.d1_byteio;

//目标：掌握使用FileOutputStream写字节数据到文件
public class Demo02 {
    public static void main(String[] args){
    /*
      构造器：
           FileOutputStream(File file)：创建字节输出流管道与源文件对象接通
           FileOutputStream(File file，boolean append)：创建字节输出流管道与源文件对象接通，可追加数据
           FileOutputStream(String filepath)：创建字节输出流管道与源文件路径接通
           FileOutputStream(String filepath，boolean append)：创建字节输出流管道与源文件路径接通，可追加数据

      写数据的api：
           write(int a)：写一个字节出去
           write(byte[] buffer)：写一个字节数组出去
           write(byte[] buffer , int pos , int len)：写一个字节数组的一部分出去

      流的关闭：
           close()：关闭流，释放资源，内部在关闭之前会先刷新流。一旦关闭，就不能再写数据
      需求1：使用 字节输出流 将"我爱Java" 写到当前模块的b.txt中。
      需求2：使用 字节输出流 向当前模块的b.txt中追加5行"乾坤未定,你我皆是黑马"。
     */
    }
}
