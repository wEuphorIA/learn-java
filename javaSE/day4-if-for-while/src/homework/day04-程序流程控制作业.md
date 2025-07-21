## 练习题一

**需求：**键盘录入三个整数，求出三个数中的最大值，并打印到控制台。

**考查知识点：**键盘录入、分支结构。

**提示：**

1. 分支结构使用if还是switch？

**代码：**

```java
public class learn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int number1 = scanner.nextInt();
        System.out.println("请输入第二个数字：");
        int number2 = scanner.nextInt();
        System.out.println("请输入一个数字：");
        int number3 = scanner.nextInt();
        if (number1 > number2) {
            if (number1 > number3){
                System.out.println("最大值是：" + number1);
            }else {
                System.out.println("最大值是：" + number3);
            }
        }else {
            if (number2 > number3){
                System.out.println("最大值是：" + number2);
            }else {
                System.out.println("最大值是：" + number3);
            }
        }
    }
}
```



## 练习题二

**需求：** 键盘录入月份数字（1-12），使用switch-case输出对应季节：

- 12、1、2月：冬季
- 3-5月：春季
- 6-8月：夏季
- 9-11月：秋季

**考查知识点：** switch-case结构、case穿透特性。

**提示：**

1. 多个case可以合并处理相同逻辑

**代码：**

```java

public class practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个月份：");
        int month = scanner.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
        }
    }
}

```



## 练习题三

**需求：**

```
1.根据程序员的工龄(整数)给程序员涨工资(整数),程序员的工龄和基本工资通过键盘录入
2.涨工资的条件如下：
     工龄       涨薪幅度
    [10-15)     +20000
    [5-10)      +10000
    [3~5)       +5000
    [1~3)       +3000        
3.运行程序:
    请输入作为程序员的你的工作的工龄:10
    请输入作为程序员的你的基本工资为:60000
    您目前工作了10年，基本工资为60000元, 应涨工资20000元,涨后工资80000元
```

**考查知识点：**键盘录入、分支结构。

**提示：**

1. 分支结构使用if还是switch？

**代码：**

```java
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入作为程序员的你的工作的工龄:");
        int workAge = scanner.nextInt();
        System.out.println("请输入作为程序员的你的基本工资为:");
        int baseSalary = scanner.nextInt();

        if (workAge >= 10 && workAge < 15) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 20000,baseSalary + 20000
            );
        } else if (workAge >= 5 && workAge < 10) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 10000,baseSalary + 10000
            );
        } else if (workAge >= 3 && workAge < 5) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 5000,baseSalary + 5000
            );
        } else if (workAge >= 1 && workAge < 3){
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 3000 ,baseSalary + 3000
            );
        }
    }
```



## 练习题四

**需求：**打印出1到100之间的既是3的倍数又是5倍数的数字以及这些数字的和。

**考查知识点：**分支结构、循环结构、累加求和。

**提示：**

1. 判断条件怎么写？
2. 如何累加求和？

**代码：**

```java
public class practice4 {
    public static void main(String[] args) {
        int sum =  0;
        for (int i = 1; i <= 100; i++){

            if (i % 3 == 0 && i % 5 == 0){
                sum += i;
                System.out.println(i);
            }

        }
        System.out.println("这些和为：" + sum);

    }
}
```



## 练习题五

**需求：**

```
1.打印所有四位数中 个位 + 千位 == 百位 + 十位 的数字
2.最后要打印符合条件的数字的总数量
3.打印格式如下:
    1010
    1021 
    1032
    1043 
    ....
    以上满足条件的四位数总共有 615 个
```

**考查知识点：**分支结构、循环结构、数值拆分、统计个数。

**提示：**

1. 类似于求水仙花数

**代码：**

```java
public class practice5 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1000; i <= 9999; i++){
            if ((i % 10 + i / 1000) == (i / 10 % 10 + i /100 % 10) ){
                System.out.println(i);
                sum++;
            }
        }
        System.out.printf("以上满足条件的四位数总共有%d个：",sum);
    }
}

```



## 练习题六

**需求：**从键盘上录入一个大于100的三位数,打印出100到该数字之间满足如下要求的数字,数字的个数,以及数字的和：

1. 数字的个位数不为7;
2. 数字的十位数不为5;
3. 数字的百位数不为3;

**考查知识点：**分支结构、循环结构、数值拆分、累加求和。

**提示：**

1. 判断条件怎么写？
2. 如何累加求和？

**代码：**

```java
public class practice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个大于100的数:");
        int number = scanner.nextInt();
        int sum = 0;
        int j = 0;
        for (int i = 100; i <= number; i++) {
            if (i % 10 != 7 &&  i /10 % 10 != 5 && i / 100 != 3){
                System.out.println(i);
                sum += i;
                j++;
            }
        }
        System.out.println("和为：" + sum);
        System.out.println("个数为：" + j);
    }
}

```

