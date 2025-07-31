package com.itheima.d1_file;

/*
目标：File类判断、获取文件信息的方法
 */
public class Demo2 {
    public static void main(String[] args) {
        //public boolean exists() 判断当前文件对象，对应的文件路径是否存在，存在返回true

        //public boolean isFile() 判断当前文件对象指代的是否是文件，是文件返回true，反之返回false

        //public boolean isDirectory() 判断当前文件对象指代的是否是文件夹，是文件夹返回true，反之返回false。

        //public String getName() 获取文件的名称（包含后缀）

        //public long length() 获取文件的大小，返回字节个数

        //public String getPath() 获取创建文件对象时，使用的路径

        //public getAbsolutePath() 获取绝对路径

        //public boolean createNewFile()：创建一个新文件（文件内容为空），创建成功返回true,反之。

        //public boolean mkdir()：用于创建文件夹，注意：只能创建一级文件夹

        //public boolean mkdirs()：用于创建文件夹，注意：可以创建多级文件夹

        //public boolean delete()：删除文件，或者空文件，注意：不能删除非空文件夹。

        //public File[] listFiles() 获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回

    }
}
