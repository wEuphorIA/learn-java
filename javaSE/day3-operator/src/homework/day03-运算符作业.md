## 练习题一

**需求：**键盘录入一个学生成绩(int类型),如果成绩大于等于60输出”及格”,如果成绩小于60输出”不及格”。

**考查知识点：**键盘录入、三元运算符。

**提示：**

1. 三元运算符的格式是什么？

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        String result = number >= 60 ? "成绩及格" : "成绩不及格";
        System.out.println(result);
    }
}
```



## 练习题二

**需求：** 键盘录入一个整数，判断该数字是否是偶数且大于10。如果满足条件输出"符合要求"，否则输出"不符合要求"。

**考查知识点：** 键盘录入、逻辑运算符、关系运算符、三元运算符。

**提示：**

1. 如何判断偶数？
2. 逻辑与运算符是什么符号？

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        String result = number % 2 == 0 && number >= 10 ? "符合要求" : "不符合要求";
        System.out.println( result);
    }
}
```

## 练习题三

**需求：** 键盘录入一个整数，先输出该数字的平方值，再将数字自增1后输出新值。

**考查知识点：** 算术运算符、自增运算符、执行顺序(自增自减运算符放在前后的区别)。

**提示：**

1. 自增运算符在前和在后有什么区别？

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        number = number * number;
        System.out.println("该数平方是：" + number);
        number++;
        System.out.println("该数平方加1是：" + number);

    }
}
```

## 练习题四

**需求：** 键盘录入销售额（整数），如果销售额大于等于10万，奖金为销售额的10%，否则奖金为销售额的5%。输出奖金金额。

**考查知识点：** 三元运算符、算术运算。

**提示：**

1. 直接使用三元运算符计算结果

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        double result = ((number >= 100000) ? number *0.1 : number * 0.05);
        System.out.println("结果是：" + result);

    }
}
```



## 练习题五

**需求：**键盘录入一个四位数，计算这个四位数的`个位、十位、百位、千位`数字之和。

**考查知识点：**键盘录入、数值拆分、算术运算。

**提示：**

1. 如何获取`个位、十位、百位、千位`数字？

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四位数字：");
        int number = scanner.nextInt();
        int a = number / 1000;
        int b = number % 1000 / 100;
        int c = number % 100 / 10;
        int d = number % 10;
        System.out.println("个位：" + d);
        System.out.println("十位：" + c);
        System.out.println("百位：" + b);
        System.out.println("千位：" + a);
        int sum = a+b+c+d;
        System.out.println("个位、十位、百位、千位、数字之和" + sum);
    }
}
```

## 练习题六

**需求：** 键盘录入年份，判断是否是闰年。闰年规则：能被4整除但不能被100整除，或能被400整除的年份。

**考查知识点：** 逻辑运算符、运算符优先级。

**提示：**

1. 判断整除用什么运算符？
2. 注意逻辑运算符连接多个条件

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        int number = scanner.nextInt();
        if ( number % 4 == 0 && number % 100 != 0 || number % 400 == 0)
        {
            System.out.println(number + "是闰年");
        }else {
            System.out.println(number + "不是闰年");
        }
    }
}
```

## 练习题七【拔高题-选作】

**需求：**创建一个程序，让用户输入一个以秒为单位的时间大小，并将其转换为小时、分钟和秒的形式输出。

**考查知识点：**键盘录入、算术运算符。

**提示：**

1. 例如：7280秒，如何拆分成时、分、秒？

**代码：**

```java
import java.util.Scanner;

public class com.itheima.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个以秒为单位的时间大小：");
        int number = scanner.nextInt();
        int a = number % 3600 / 60;
        int b = number % 60;
        int c = number / 3600;
        System.out.println(c + ":" + a + ":" + b);

    }
}
```

