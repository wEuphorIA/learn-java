## 编程题一

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（没有子目录）**，请编写程序统计`D:\itheima`目录的大小。

**提示：**

1. 如果没有`D:\itheima`目录，就在任意盘下创建一个`itheima`目录
2. 统计目录的大小就是统计目录中所有文件的大小之和

**代码**：

```java
public class Practice1 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");

        if (!file.exists()){
            boolean mkdir = file.mkdir();
            System.out.println(mkdir);
        }else {
            //
            System.out.println("itheima已存在");
        }

        System.out.println(getFileSize(file));

    }

    public static Long getFileSize(File dir){
        long size = 0;
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {

                size += file.length(); // 累加文件大小

            }
        }
        return size;
    }
}

```

## 编程题二

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（有子目录）**，请编写程序统计`D:\itheima`目录的大小。

**提示：**统计目录的大小就是统计目录(及其子目录)中所有文件的大小之和

**代码**：

```java
public static void main(String[] args) {
        File file=new File("D:\\itheima");

        if (!file.exists()){
            boolean mkdir = file.mkdir();
            System.out.println(mkdir);
        }else {
            //
            System.out.println("itheima已存在");
        }

        System.out.println(getFileSize(file));

    }

    public static Long getFileSize(File dir){
        long size = 0;
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length(); // 累加文件大小
                } else {
                    size += getFileSize(file); // 递归处理子目录
                }
            }
        }
        return size;
    }
```

## 编程题三

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（没有子目录）**，请编写程序将`D:\itheima`目录中的**其中一个文件**复制到当前模块下的`itheima`目录中，文件名不变。

**代码：**

```java
public class Practice2 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");
        File[] files = file.listFiles();
        File file1 = null;
        if (files != null) {
            file1 = files[0];
        }
        String srcPath = file1.getAbsolutePath();
        System.out.println(srcPath);


        File file2 = new File("D:\\itheima\\itheima\\");
        boolean mkdir = file2.mkdir();
        System.out.println(mkdir);

        String path = file2.getPath();
        System.out.println(path);

        try {
            boolean b = copyFile(srcPath, path +"\\"+ file1.getName());
            System.out.println(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean copyFile(String srcPath, String destPath) throws  IOException{
        // 需求：复制照片。
        // 1、创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream(srcPath);
        // 2、创建一个字节输出流管道与目标文件接通。
        OutputStream os = new FileOutputStream(destPath);
        // 3、创建一个字节数组，负责转移字节数据。
        byte[] buffer = new byte[1024]; // 1KB.
        // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
        int len; // 记住每次读取了多少个字节。
        while ((len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
        System.out.println("复制完成！！");
        return true;
    }
}

```



## 编程题四

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（没有子目录）**，请编写程序将`D:\itheima`目录中的**所有文件**复制到当前模块下的`itheima`目录中。

**代码：**

```java
public class Practice2 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");
        File[] files = file.listFiles(pathname -> pathname.isFile());

        String srcPath ;

        File file2 = new File("D:\\itheima\\itheima");
        boolean mkdir = file2.mkdir();
        System.out.println(mkdir);
        String path = file2.getPath();
        System.out.println(path);

        for (File file1 : files){
            srcPath = file1.getPath();
            String destPath = file2.getPath() + "\\" + file1.getName();
            try {
                boolean b = copyFile(srcPath, destPath);
                System.out.println(b);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static boolean copyFile(String srcPath, String destPath) throws  IOException{
        // 需求：复制照片。
        // 1、创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream(srcPath);
        // 2、创建一个字节输出流管道与目标文件接通。
        OutputStream os = new FileOutputStream(destPath);
        // 3、创建一个字节数组，负责转移字节数据。
        byte[] buffer = new byte[1024]; // 1KB.
        // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
        int len; // 记住每次读取了多少个字节。
        while ((len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
        System.out.println("复制完成！！");
        return true;
    }
}

```



## 编程题五

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（有子目录）**，请编写程序将`D:\itheima`目录中的**所有文件和子目录(包括子目录中的文件)**复制到当前模块下的`itheima`目录中。

**提示：**

1. IO流只能复制文件，无法复制目录。
2. 当File是目录时，我们只需要在目的地创建一个和File同名的目录即可。然后将子目录中的文件都复制到新目录中。
3. 需要递归复制，可以给方法设计两个参数，如下所示：

```java
/**
     * 复制目录
     * @param sourceFile 要复制的目录
     * @param destFile 复制到哪个目录中
     */
public static void copyDirectory(File sourceFile,File destFile) throws IOException {

}
```

**代码：**

```java
public class Practice3 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");
        File file2 = new File("D:\\itheima\\itheima");

        if (!file2.exists() && !file2.mkdirs()) {
            System.out.println("创建失败");
        }
        // 把文件提取出来
        File[] files = file.listFiles(pathname -> pathname.isFile());

        for (File file1 : files){
            String srcPath = file1.getPath();
            String destPath = file2.getPath() + "\\" + file1.getName();
            try {
                boolean b = copyFile(srcPath, destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            copyDirectory(file,file2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean copyFile(String srcPath, String destPath) throws IOException {
        // 需求：复制照片。
        // 1、创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream(srcPath);
        // 2、创建一个字节输出流管道与目标文件接通。
        OutputStream os = new FileOutputStream(destPath);
        // 3、创建一个字节数组，负责转移字节数据。
        byte[] buffer = new byte[1024]; // 1KB.
        // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
        int len; // 记住每次读取了多少个字节。
        while ((len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
        System.out.println("复制完成！！");
        return true;
    }

    public static void copyDirectory(File sourceFile,File destFile) throws IOException {

        if (!destFile.exists() && !destFile.mkdirs()) {
            throw new IOException("无法创建目标目录");
        }

        File[] children = sourceFile.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.getCanonicalPath().equals(destFile.getCanonicalPath())) {
                    continue;
                }
                File destChild = new File(destFile, child.getName());
                if (child.isFile()) {
                    copyFile(child.getPath(), destChild.getPath());
                } else if (child.isDirectory()) {
                    copyDirectory(child, destChild); // 递归处理子目录
                }
            }
        }
    }
}
```



