## 一、问答题：

### 1. 什么是正则表达式，有什么作用？

```
正则表达式：就是由一些特定的字符组成字符串，代表的是一个规则。
作用1：用来校验数据格式是否符合规则(合法)。
作用2：在一段文本中查找满足要求的内容。

```

### 2. 什么是集合？集合和数组有什么区别？

~~~java
集合是一种容器，用来装数据的，类似于数组，也是用来存储一批同类数据。
数组长度固定，集合不固定
~~~

### 3.请描述ArrayList\<E>中的\<E>的含义？

```
泛型<E> 是 Java中的泛型符号，可以存储任意指定类型的元素。
```

### 4、8种基本数据类型对应的包装类分别是什么？

``` 
byte - Byte
short - Short
int - Integer
long - Long
float - Float
double - Double
char - Character
boolean - Boolean
```



## 二、编程题：

### 第一题

#### 需求：

1. 有一个保存姓名的集合，如下所示：

   ```java
   ArrayList<String> list = new ArrayList<>();
   list.add("张无忌");
   list.add("周芷若");
   list.add("赵敏");
   list.add("张强");
   list.add("张三丰");
   ```

2. 把集合中所有以"张"开头，且是3个字的元素存储到一个新的集合,最后遍历打印新集合中的数据。

#### 提示：

1. 可能用到String类的的方法：**startWith(...)：判断是否以某个字符串开头；length()：获取字符串长度**

#### 代码

```java
public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("张") && list.get(i).length() == 3) {
                list1.add(list.get(i));
            }
        }
        System.out.println(list1);
    }
```

### 第二题

#### 需求

向ArrayList集合中存入以下字符串："I", "am", "learning", "Java", "at", "heima"，尝试将集合中的所有字符串转换成大写，再打印到控制台。打印结果为：I AM LEARNING JAVA AT HEIMA

#### 代码

~~~java
public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("learning");
        list.add("Java");
        list.add("at");
        list.add("heima");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).toUpperCase() + " ");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
~~~





