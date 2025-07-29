## 编程题一

- 在当前模块下新建students.txt文件，文件内容如下

```
张三,23
李四,24
王五,25
```

- 使用==**字符缓冲流**==读取”students.txt”文件，将每行数据封装为一个Student对象，并将Student对象存储到一个集合
- 遍历并打印集合的所有Student信息

```java
public class Practice1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\students.txt");
        ArrayList<Student> students = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null){
                String[] split = line.split(",");
                if (split.length == 2){
                    students.add(new Student(split[0], Integer.parseInt(split[1])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       students.forEach(System.out::println);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{

    private String name;

    private int age;

}
```



## 编程题二

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件，请编写程序将`D:\itheima`目录中的**其中一个文件**复制到当前模块下的`itheima`目录中，文件名不变。

**要求：**

​	请使用 ==字节缓冲流== 和 ==commons-io==两种方式 实现。

**使用字节缓冲流代码：**

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
**使用commons-io代码：**

```java
public static void main(String[] args) throws IOException {
        File sourceDir = new File("D:\\itheima");
        File targetDir = new File("D:\\itheima\\itheima");

        // 1. 确保目标目录存在
        if (!targetDir.exists()) {
            boolean created = targetDir.mkdirs();
            if (!created) {
                System.out.println("无法创建目录: " + targetDir);
            }
        }
        // 2. 获取第一个文件
        File[] files = sourceDir.listFiles(File::isFile);

        File sourceFile = files[0];

        // 3. 执行复制
        File targetFile = new File(targetDir, sourceFile.getName());
        FileUtils.copyFile(sourceFile, targetFile);
        System.out.println("已复制: " + sourceFile.getName() + " -> " + targetFile);

    }
```



## 编程题三

**需求：**

​	假设在`D:\itheima\`目录下有若干个文件或者子目录，请编写程序将`D:\itheima`目录复制到当前模块下，目录名也叫`itheima`。

**要求：**使用commons-io完成即可

**代码：**

```java
public static void main(String[] args) throws IOException {
        File sourceDir = new File("D:\\itheima");
        File targetDir = new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\itheima");
        FileUtils.copyDirectory(sourceDir, targetDir);
    }
```



## 编程题四

**需求：**

​	在当前模块下新建一个spring.properties文件，内容如下：

```properties
#spring.datasource.driverClassName是键，com.mysql.cj.jdbc.Driver是值
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/zzyl
spring.datasource.username=root
spring.datasource.password=1234
```

请在程序中读取上述文件中的内容，并采用**日志**的方式打印到控制台。

**代码：**

```java
public class Practice4 {
    private static final Logger log = LoggerFactory.getLogger(Practice4.class);

    @SneakyThrows
    public static void main(String[] args) {
        String s = FileUtils.readFileToString(new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\spring.properties"), "utf-8");
        log.info(s);
    }
}
```

