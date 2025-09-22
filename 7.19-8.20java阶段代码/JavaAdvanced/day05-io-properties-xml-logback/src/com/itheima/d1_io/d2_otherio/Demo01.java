package com.itheima.d1_io.d2_otherio;

//目标：了解InputStreamReader和OutputStreamWriter的使用
/**
 * InputStreamReader(InputStream is)：几乎不用，可以把原始的字节流按照代码默认编码转换成字符输入流
 * InputStreamReader(InputStream is ，String charset)：可以把原始的字节流按照指定编码转换成字符输入流
 * 需求：使用字符输入转换流读取f-gbk.txt文件内容，使其读取内容不乱码
 */
/**
 * OutputStreamWriter(OutputStream os)：几乎不用，可以把原始的字节输出流按照代码默认编码转换成字符输出流
 * OutputStreamWriter(OutputStream os，String charset)： 可以把原始的字节输出流按照指定编码转换成字符输出流
 * 需求：将字符串"黑马程序员"以GBK编码方式写出到当前模块下的e.txt中
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //需求：使用字符输入流读取f-gbk.txt文件内容，观察读取结果。
    }


}
