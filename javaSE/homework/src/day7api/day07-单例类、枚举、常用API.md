## 一、问答题：

### 1. 通过查文档如何使用API

```
java官方给我们提供了API文档，直接查文档就行
```

### 2. 请问String的直接赋值和new对象两种创建对象的区别？

~~~java
string直接赋值在字符串常量池中创建 如果有会复用，没有则创建
new对象在堆中创建，不管有没有都会创建一个新的对象
~~~



## 二、编程题：



### 第一题

#### 需求

请从控制台接收一个生日，要求格式yyyy-MM-dd，例如：2000-02-13。请编程解析出年、月、日，并打印。

#### 提示：

可能用到的方法：**substring(...)**：字符串截取；**indexOf(...)**：获取字符第一次出现的索引；**lastIndexOf(...)**：获取字符最后一次出现的索引；**split(...)**：字符串切割

#### 代码

~~~java
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个生日格式（yyyy-MM-dd)：");
        String birthday = scanner.next();

        // 截取
        int i = birthday.indexOf("-");
        int j = birthday.lastIndexOf("-");

        String year = birthday.substring(0,i);
        System.out.println("年：" + year);

        String month = birthday.substring(i+1,j);
        System.out.println("月：" + month);

        String day = birthday.substring(j+1);
        System.out.println("日：" + day);
    }
~~~

### 第二题

#### 需求

英文绕口令：peter piper picked a peck of pickled peppers 统计这段绕口令有多少个以p开头的单词

#### 代码

```java
public static void main(String[] args) {
        String s = "peter piper picked a peck of pickled peppers";
        int count = 0;
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].contains("p") ) {
                count++;
            }
        }
        System.out.println("以 'p' 开头的单词总数: "  + count);
    }
```

### 第三题

#### 需求：

1. 准备一个字符串内容如： “20 30 33 55 66 88”
2. 对字符串进行切割，对所有的整数求和，并计算平均值，保留两位小数

#### 提示：

1. 可能用到String类的的方法：**split(...)**：字符串切割
2. 字符串类型数字转换成整数：int num = **Integer.parseInt(字符串类型数字)** 。例如：int num = **Integer.parseInt("66")** ; //66

#### 代码

```java
public static void main(String[] args) {
        String s = "20 30 33 55 66 88";
        String[] s1 = s.split(" ");
        int sum = 0;
        for (int i = 0; i < s1.length; i++){
            sum += Integer.parseInt(s1[i]);
        }
        System.out.println("这些数的和为" + sum);
        double avg = sum * 1.0 / s1.length;
        System.out.println( "这些数的平均值为" + String.format("%.2f", avg));
    }
```



### 第四题

#### **需求 :**   

​	请键盘录入生日日期(只需要年月日,（如："1998年08月08日"）)，然后计算当前日期距离生日那天间隔多少年？多少月？多少天

#### **提示：**

​	使用LocalDate和Period对象(Period对象自己查资料自学)

#### **代码：**

```java
public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个生日格式（yyyy-MM-dd)：");

        String birthday = scanner.next();
        LocalDate parse = LocalDate.parse(birthday, formatter);
        LocalDate now = LocalDate.now();

        Period period = Period.between(parse, now);
        System.out.printf("距离生日那天间隔%d年%d月%d日", period.getYears(), period.getMonths(), period.getDays());
    }
```









