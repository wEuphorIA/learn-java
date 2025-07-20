**说明：做此作业之前，需要先预习明天《算术运算符》这一章节的内容**

**说明：做此作业之前，需要先预习明天《算术运算符》这一章节的内容**

**说明：做此作业之前，需要先预习明天《算术运算符》这一章节的内容**

## 练习题一

**需求：**编写一个程序，要求用户依次输入用户的名字、年龄和身高，并将这些信息逐一打印出来，运行效果如下：

```
请输入姓名：
张伟
请输入年龄：
22
请输入身高：
1.83
姓名：张伟
年龄：22岁
身高：1.83米
```

**考查知识点：**键盘录入、定义变量、字符串拼接

**提示：**

1. 键盘录入使用什么？使用步骤是什么？
2. 用户输入的姓名、年龄、身高分别用什么类型的变量存储？

**代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入身高：");
        double height = sc.nextDouble();
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age + "岁");
        System.out.println("身高：" + height + "米");
    }
}
```



## 练习题二

**需求：**编写一个程序，要求用户输入一个小数，在程序中对这个小数四舍五入后取整，输出原始小数和四舍五入取整后的值，例如：

```
请输入一个小数：
5.55
原始小数是：5.55
四舍五入后取整是：6
```

**考查知识点：**键盘录入、类型转换

**提示：**

1. 借助AI查询如何使用键盘录入得到一个小数？
2. 如何四舍五入后取整？注意：`(int)num` 这样做是直接舍弃掉小数部分，需要怎么做才可以四舍五入?

**代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        double number = scanner.nextDouble();
        System.out.println("原始小数是：" + number);
        System.out.println("四舍五入后取整是：" + Math.round(number));

    }
}
```



## 练习题三

**需求：**从键盘录入两个整数，计算它们的平均值（允许是小数）。

**考查知识点：**键盘录入、算术运算。

**提示：**

1. 两个整数使用/相除，如何得到小数？

**代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        double a = sc.nextDouble();
        System.out.println("请输入第二个数字");
        double b = sc.nextDouble();
        System.out.println("两个数字的平均值为：" + (a + b)/2);
    }
}
```



## 练习题四

**需求：**创建一个程序，接受两个浮点数作为输入，并计算它们的和、差、积和商，然后输出结果。

**考查知识点：**键盘录入、算术运算。

**提示：**

1. 键盘录入使用什么？使用步骤是什么？

**代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        double a = sc.nextDouble();
        System.out.println("请输入第二个数字");
        double b = sc.nextDouble();
        System.out.println("两个数字的和为：" + (a + b));
        System.out.println("两个数字的差为：" + (a - b));
        System.out.println("两个数字的积为：" + (a * b));
        System.out.println("两个数字的商为：" + (a / b));

    }
}
```



## 练习题五

**需求：**实现一个简单的摄氏度到华氏度的转换器。提示用户输入摄氏温度，然后计算并输出对应的华氏温度（华氏温度 = 摄氏温度 × 9/5 + 32）。

**考查知识点：**键盘录入、算术运算。

**提示：**

1. 关注计算公式

**代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入摄氏温度");
        double a = sc.nextDouble();
        System.out.println("转换后的华氏温度为：" + (a * 1.8 + 32));


    }
}
```



## 练习题六

**需求：**小明左、右手中各拿1张纸牌（比如：黑桃10和红桃8，数字10和8可通过键盘录入），要求编写代码交换小明手中的牌，要求同一只手不能同时拿两张牌。程序执行，在控制台输出效果：

```
请输入小明左手中的纸牌：
10
请输入小明右手中的纸牌：
8

互换前小明手中的纸牌：
左手中的纸牌：10
右手中的纸牌：8

互换后小明手中的纸牌：
左手中的纸牌：8
右手中的纸牌：10  
```

**考查知识点：**键盘录入、变量赋值。

**提示：**

1. 键盘录入使用什么？使用步骤是什么？
2. 交换两个杯子中的水，你怎么做？交换两只手中的牌(同一只手不能同时拿两张牌)和交换连个被子中的水是一样的做法。

**代码：**

```java

```

