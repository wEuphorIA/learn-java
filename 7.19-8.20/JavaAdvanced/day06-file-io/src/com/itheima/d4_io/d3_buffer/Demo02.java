package com.itheima.d4_io.d3_buffer;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    需求：把《出师表》的文章顺序进行恢复到一个新文件中。
    分析：
        定义一个缓存字符输入流管道与源文件接通。
        定义一个List集合存储读取的每行数据。
        定义一个循环按照行读取数据，存入到List集合中去。
        对List集合中的每行数据按照首字符编号升序排序。
        定义一个缓存字符输出管道与目标文件接通。
        遍历List集合中的每个元素，用缓冲输出管道写出并换行。
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        try(
                BufferedReader bf = new BufferedReader(new FileReader("day06-file-io\\src\\csb.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("day06-file-io\\src\\csb_new.txt"))
        ) {
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) != null){
                lines.add(line);
            }
            Collections.sort(lines);

            for (String s : lines) {
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
