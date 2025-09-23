package com.itheima.d1_io.d1_buffer;

//目标：掌握缓冲字符流读写取数据
/** BufferedReader缓冲字符输入流
 * 作用：提高字符输入流读取数据的性能，除此之外多了按照行读取数据的功能
 *      BufferedReader(Reader r)：把原始的字符输入流包装成高效的字符缓冲输入流管道，从而提高字符输入流读数据的性能
 * 新增功能：
 *      String readLine()：读取一行数据返回，如果读取没有完毕，无行可读返回null
 */
/** BufferedWriter 缓冲字符输出流
 * 作用：提高字符输出流写取数据的性能，除此之外多了换行功能
 *      BufferedWriter(Writer w)：把原始的字符输出流包装成高级的缓冲字符输出流管道，从而提高字符输出流写数据的性能
 * 新增功能：
 *      newLine()：换行操作
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //需求：使用字符流(BufferedReader、BufferedWriter)完成文件复制。
    }
}
