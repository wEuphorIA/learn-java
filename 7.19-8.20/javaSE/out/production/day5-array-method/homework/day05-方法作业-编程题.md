### 练习题一

**需求：** 定义一个方法判断年份是否是闰年（能被4整除但不能被100整除，或能被400整除）。

**考查知识点：** 方法定义、逻辑运算符。

**代码：**

```java
public boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
```



### 练习题二

**需求：** 定义一个方法，判断一个整数是否是质数（只能被1和自身整除）。

**考查知识点：**方法的定义和调用，循环，条件分支。

**提示：**

1. 质数：只能被1和自身整除的整数就是质数。例如：2、3、5、7、11、...都是质数，9不是质数，因为9除了被1和自身整除之外还可以被3整除。

**代码：**

```java
public boolean isPrime(int num){
        if (num <= 1) {
            return false;
        }
        if (num ==  2){
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
```

### 练习题三

**需求：** 定义一个方法，统计字符串中大写字母的个数（例如输入"HelloWorld"，返回2）。

**考查知识点：** 方法的定义和调用，字符判断。

**提示：**

1. 字符串可以转换成字符数组之后再遍历。char[] chs = s.toCharArray();  s表示字符串，chs是转之后的字符数组。

2. 判断字符是否是大写字母：ch >='A' && ch <='Z'，ch表示每个字符。

**代码：**

```java
public int majusculeTotal(String str){
        int count = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch >='A' && ch <='Z') {
                count++;
            }
        }
        return count;
    }
```





### 练习题四

**需求：**定义一个方法，接收一个字符串，分别打印出其英文字母、空格、数字和其它字符的个数。

**考查知识点：** 方法的定义和调用，字符判断。

**提示：**

1. 字符串可以转换成字符数组之后再遍历。char[] chs = s.toCharArray();  s表示字符串，chs是转之后的字符数组

2. 判断字符是否是字母：(ch >='a' && ch <='z') || (ch >='A' && ch <='Z')，ch表示每个字符。

**代码：**

```java
public void total(String str) {
        int letters = 0;
        int number = 0;
        int other = 0;
        int space = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                letters++;
            } else if (ch >= '0' && ch <= '9') {
                number++;
            } else if (ch == ' ') {
                space++;
            } else {
                other++;
            }
        }
        // 格式化输出结果
        System.out.println("英文字母个数: " + letters);
        System.out.println("空格个数: " + space);
        System.out.println("数字个数: " + number);
        System.out.println("其他字符个数: " + other);
    }
```







