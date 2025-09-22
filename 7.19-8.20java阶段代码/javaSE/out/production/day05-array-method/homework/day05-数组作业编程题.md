## 练习题一

**需求：**现有一个整型数组{100,50,90,60,80,70}，请编写程序，计算数组中元素的平均值(允许是小数)。

**考查知识点：**数组的静态初始化、数组遍历、数组求和。

**提示：**

1. 求平均值公式：平均值 = 总和/总数

**代码：**

```java
int[] arr = {100,50,90,60,80,70};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组中元素的平均值" + sum/arr.length);
```



## 练习题二

**需求：**基于**“练习题一”**如果要去掉最大值和最小值后求平均分，又该怎么做？

**代码：**

```java
sum = 0;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length -1; i++){
            sum += arr[i];
        }
        System.out.println("数组中元素去掉一个最大值和一个最小值的平均值" + sum/(arr.length - 2));
```



## 练习题三

**需求：**基于**“练习题二”**如果输出数组中所有高于平均值的数，又该怎么做？

**代码：**

```java
System.out.println("数组中元素大于平均值的元素");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > sum/(arr.length - 2)) {
                System.out.print(arr[i] + "   ");
            }
        }
```



## 练习题四

**需求：** 筛选数组中的回文数：

1. 创建包含20个随机三位数的数组（100-999）
2. 找出数组中所有回文数（如121、343等正反读相同的数）
3. 输出原始数组和所有回文数

**考查知识点：** 数组遍历、数值拆分、回文判断

**提示：**

1. 通过取余分离各位数字。
2. 回文数有什么特点？

**代码：**

```Java
System.out.print("数组中回文数元素为：");
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int a = temp / 100;
            int c = temp % 10;
            if (a == c) {
                System.out.print(temp + "  ");
            }
        }
```
