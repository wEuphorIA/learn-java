## 一、简答题

### 1. 什么是集合？集合和数组有什么区别？

~~~java
集合是用于存储数据的容器，是长度不固定的数据结构，提供丰富的操作方法（如增删查改）。
数组长度固定，集合长度固定
~~~

### 2.请描述ArrayList\<E>中的\<E>的含义？

```
<E>是泛型类型参数，表示 ArrayList可以存储任意类型的元素，但需在声明时指定具体类型。
```

### 3.请说出基本数据类型对应的八个包装类分别是什么? 

```java
    - Byte
    - Short
    - Integer
    - Long
    - Float
    - Double
    - Character
    - Boolean
```

### 4.请描述 List 接口 和 Set接口的特点

```
  - List
    - 允许重复
    - 有序（存储顺序与插入顺序一致）
    - 支持索引访问
    - 实现类ArrayList、LinkedList、Vector
  - Set
    - 不允许重复
    - 无序（存储顺序与插入顺序无关）
    - 不支持索引访问
    - 实现类HashSet、TreeSet、LinkedHashSet
```

### 5.请描述ArrayList集合底层存储数据的原理

```
动态数组
数组元素的类型为Object类型

```



## 二、编程题

### 第1题

#### 需求

向ArrayList集合中存入以下字符串："I", "am", "learning", "Java", "at", "heima"，尝试将集合中的所有字符串转换成大写，再打印到控制台。打印结果为：I AM LEARNING JAVA AT HEIMA

#### 代码

~~~java
public class Practice1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("learning");
        list.add("Java");
        list.add("at");
        list.add("heima");

        for (int i = 0; i < list.size(); i++){
            String upperCase = list.get(i).toUpperCase();
            list1.add(upperCase);
        }
        System.out.println(list1);
    }
}

~~~



### 第2题

#### 需求：

以下三年级一班的学生信息，后来张三丰搬到了武汉，李老师需要将张三丰对应的住址改掉，请用程序完成需求，并将学生的信息打印到控制台上。

![1568190215542](assets\1568190215542.png)	

#### 提示：

```
1、学生信息需要定义一个javabean类封装学生信息
2、将四个学生信息保存到ArrayList集合中
3、遍历集合，根据条件修改集合中的学生信息
```

#### 代码实现

```java
//Student类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String address;
}
```

```java
//测试类
public class Practice2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张无忌", "河北"));
        list.add(new Student(2, "张三丰", "河南"));
        list.add(new Student(3, "赵敏", "蒙古"));
        list.add(new Student(4, "周芷若", "四川"));
        System.out.println("修改前");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if ("张三丰".equals(s.getName())) {
                s.setAddress("武汉");
            }
        }
        System.out.println("修改后");
        System.out.println(list);
    }
}

```





### 第3题

#### 需求：

有4个人参加考试，考试成绩如图所示,录取3名学生，淘汰分数最低的一名，设计一个程序完成需求。

![1568190215542](assets\1568256886975.png)



#### 训练提示

```
1、学生信息需要定义一个javabean类封装学生信息
2、将四个学生信息保存到ArrayList集合中
3、对集合中的学生按照分数升序排序，排序完成之后删除最后一个元素即可。集合也有sort(比较器)方法。
```

#### 代码实现

```java
//Student类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int score;
}
```

```java
public class Practice3 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"小亮",99));
        list.add(new Student(2,"小强",85));
        list.add(new Student(3,"小响",90));
        list.add(new Student(4,"小勇",75));

        list.sort(Comparator.comparingInt(Student::getScore));
        System.out.println("删除前");
        list.forEach(System.out::println);
        list.remove(0);
        System.out.println("删除后");
        list.forEach(System.out::println);
    }
}

```



