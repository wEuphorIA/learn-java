## 编程题一

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（只有文件没有目录）**，请编写程序统计`D:\itheima`目录的大小。

**提示：**

1. 如果没有`D:\itheima`目录，就在任意盘下创建一个`itheima`目录
2. 统计目录的大小就是统计目录中所有文件的大小之和

**代码**：

```java
private static void totalSize(File file) {
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return;
        }
        long sum = 0L;
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isFile()) {
                sum += f.length();
            }
        }
        System.out.println("这个文件夹中的数据大小为 = " + sum);
    }
```

## 编程题二

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件和目录，请编写程序统计`D:\itheima`目录的大小。

**提示：**统计目录的大小就是统计目录(及其子目录)中所有文件的大小之和

**代码**：

```java
private static long totalSize(File file) {
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return -1;
        }
        long sum = 0L;
        File[] files = file.listFiles();
        if (files == null) {
            return -1;
        }
        for (File f : files) {
            if (f.isFile()) {
                sum += f.length();
            }
            if (f.isDirectory()){
                long l = totalSize(f);
                sum += l;
            }
        }
       return sum;
    }
```

## 编程题三

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（只有文件没有目录）**，请编写程序将`D:\itheima`目录中的**一个文件**复制到当前模块下的`itheima`目录中，文件名不变。

**要求：**不使用commons-io框架

**代码：**

```java
public class Practice5 {
    private static final String SRC_PATH = "D:\\itheima\\";
    private static final String TAR_PATH = "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\";

    public static void main(String[] args) {
        BufferedInputStream bs = null;
        BufferedOutputStream bos = null;
        try  {
            File file = new File(SRC_PATH);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                if (file1.isFile()) {
                    bs = new BufferedInputStream(new FileInputStream(file1.getAbsolutePath()));
                    bos = new BufferedOutputStream(new FileOutputStream(TAR_PATH + file1.getName()));
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = bs.read(buffer)) != -1) {
                        bos.write(buffer, 0, len);
                    }
                }
            }

            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bs != null){
                try {
                    bs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

```

## 编程题四

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件**（只有文件没有目录）**，请编写程序将`D:\itheima`目录中的**所有文件**复制到当前模块下的`itheima`目录中。

**要求：**不使用commons-io框架

**代码：**

```java
public class Practice5 {
    private static final String SRC_PATH = "D:\\itheima\\";
    private static final String TAR_PATH = "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\";

    public static void main(String[] args) {
        BufferedInputStream bs = null;
        BufferedOutputStream bos = null;
        try  {
            File file = new File(SRC_PATH);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                if (file1.isFile()) {
                    bs = new BufferedInputStream(new FileInputStream(file1.getAbsolutePath()));
                    bos = new BufferedOutputStream(new FileOutputStream(TAR_PATH + file1.getName()));
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = bs.read(buffer)) != -1) {
                        bos.write(buffer, 0, len);
                    }
                }
            }

            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bs != null){
                try {
                    bs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

```



## 编程题五

- 在当前模块下手动新建students.txt文件，文件内容如下

  ```java
  张三,23
  李四,24
  王五,25
  ```

- 使用==**字符缓冲流**==读取”students.txt”文件，将每行数据封装为一个Student对象，并将Student对象存储到一个集合

- 遍历并打印集合的所有Student信息

```java
public class Student{
    private String name;
    private int age;
}
public class Practice6 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\Practice6\\students.txt"));
        ) {
            String line;
            ArrayList<Student> students = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                students.add(new Student(split[0],Integer.parseInt(split[1])));
            }
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 编程题六

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件和目录，请编写程序将`D:\itheima`目录复制到当前模块下，目录名也叫`itheima`。

**要求：**使用commons-io完成即可

**代码：**

```java
public class Practice7 {
    private static final String SRC_PATH = "D:\\itheima\\";
    private static final String TAR_PATH = "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\";

    public static void main(String[] args) throws IOException {
        FileUtils.copyDirectory(new File(SRC_PATH),new File(TAR_PATH + "itheima"));
    }
}
```


