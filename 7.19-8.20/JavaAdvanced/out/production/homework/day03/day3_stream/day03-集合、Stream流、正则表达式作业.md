# 1. 简答题

## 简答题一

写出HashMap、TreeMap、HashMap的底层数据结构，以及特点

```java
HashMap 基于哈希表 无序无重复无索引
TreeMap 基于红黑树 升序无重复无索引
LinkedHashMap 哈希表+双向链表 有序无重复无索引
```

## 简答题二

请写出Stream流有哪些中间操作方法，并描述其含义

```java
filter 过滤
sorted 排序
limit 取前几个数
skip 跳过
distinct 去重
map 转换
concat 合并两个流
```

请写出Stream流有哪些终结操作方法，并描述其含义

```java
foreach 输出
count 统计
max 最大值
min 最小值
```

请写出Stream流有哪些收集方法，并描述其含义

```java
collect（Collectors.toList）; 将结果返回一个集合
collect（Collectors.toSet()）; 返回一个set集合
collect（collectos.toMap（）） {
	name ->  name;
	value -> value;
};
 
```

# 2. 编程题

## 编程题一

需求 :  利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量 

- 如用户输入字符串:"helloworldjava",程序输出结果：
- h-1 e-1 l-3 o-2 w-1 r-1 d-1 j-1 a-2 v-1   （顺序不做要求）

```java
public static void main(String[] args) {
        String info = "helloworldjava";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < info.length(); i++) {
            char c = info.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.forEach((k, v) -> System.out.print(k + "-" + v + " "));
    }
```

## 编程题二

按要求完成下面的需求：

```java
1.定义一个字符串数组
	Integer[] arr = {123,456,777,345,345,222,999,222,110,120,567};
3.对元素按照降序排列
4.截取前面8个
5.跳过前面3个
6.去除重复元素
7.过滤保留偶数元素
8.遍历打印剩余元素

学习小技巧：调用完一个方法之后使用forEach测试一下，看是否和目标项目，这样可以加深印象。
```

```java
public static void main(String[] args) {
        Integer[] arr = {123,456,777,345,345,222,999,222,110,120,567};
        //3.对元素按照降序排列
        //4.截取前面8个
        //5.跳过前面3个
        //6.去除重复元素
        //7.过滤保留偶数元素
        //8.遍历打印剩余元素
        Arrays.stream(arr).sorted((o1, o2) -> o2-o1).limit(8).skip(3)
                .distinct().filter(e -> e%2==0).forEach(System.out::println);
    }
```



## 编程题三

按要求完成下面的需求

1. 创建一个Student类，有name和age两个属性，生成构造器、get、set、toString等方法	

2. 创建一个测试类，请基于下面代码按要求完成代码

```java
import java.util.Collections;

public class Demo03 {
    public static void main(String[] args) {
        //准备好一个集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"金毛狮王","周芷若", "周芷若","张无忌","灭绝师太","灭绝师太","张三丰", "张翠山", "小昭", "赵敏");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杨过","小龙女","张三丰", "张翠山", "小昭", "赵敏");
      
        //1.获取两个集合的流，将两个流合并为一个流
        
        //2.过滤姓名长度大于2的元素、截取前面8个、跳过前面1个、去重重复元素
        
        //3 将Stream流中的字符串名字转换成Student对象，对象的年龄取[18,100]之间的随机整数，转换完成之后遍历打印。
    }
}
```

代码如下

```java
public static void main(String[] args) {
        //准备好一个集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"金毛狮王","周芷若", "周芷若","张无忌","灭绝师太","灭绝师太","张三丰", "张翠山", "小昭", "赵敏");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杨过","小龙女","张三丰", "张翠山", "小昭", "赵敏");

        //1.获取两个集合的流，将两个流合并为一个流
        Stream<String> stream = list1.stream();
        Stream<String> stream1 = list2.stream();
        Stream<String> stream2 = Stream.concat(stream, stream1);

        //2.过滤姓名长度大于2的元素、截取前面8个、跳过前面1个、去重重复元素
        Stream<String> stream3 = stream2.filter(name -> name.length() > 2)
                .limit(8).skip(1).distinct();


        //3 将Stream流中的字符串名字转换成Student对象，对象的年龄取[18,100]之间的随机整数，转换完成之后遍历打印。
        Random random = new Random();
        stream3.map(name -> new Student(name, (random.nextInt(18,101))))
                .forEach(System.out::println);

    }
```



## 编程题四

按要求完成下面的需求

```java
1.创建一个Student类，有name和age两个属性，生成构造器、get、set、toString等方法(可以使用上一题的Student类)
2.创建一个ArrayList集合，往集合中添加10个Student对象
3.使用Stream流过滤集合中年龄>20的元素
4.截取前面的8个元素
5.跳过前面的2个元素
6.把Stream流中剩余的元素回收到list集合
7.遍历打印list集合中的学生对象

学习小技巧：学习小技巧：调用完一个方法之后使用forEach测试一下，看是否和目标项目，这样可以加深印象。
```

下面是给你提供好的材料代码

```java
List<Student> list=new ArrayList<>();
list.add(new Student("张三",20));
list.add(new Student("李四",18));
list.add(new Student("王五",19));
list.add(new Student("赵六",25));
list.add(new Student("前妻",27));
list.add(new Student("王炸",28));
list.add(new Student("小王",26));
list.add(new Student("大王",24));
list.add(new Student("蘑菇头",23));
list.add(new Student("妹爷",29));
list.add(new Student("老王",30));
list.add(new Student("老李",22)); 
```

代码如下：

```java
public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三",20));
        list.add(new Student("李四",18));
        list.add(new Student("王五",19));
        list.add(new Student("赵六",25));
        list.add(new Student("前妻",27));
        list.add(new Student("王炸",28));
        list.add(new Student("小王",26));
        list.add(new Student("大王",24));
        list.add(new Student("蘑菇头",23));
        list.add(new Student("妹爷",29));
        list.add(new Student("老王",30));
        list.add(new Student("老李",22));

        //3.使用Stream流过滤集合中年龄>20的元素
        //4.截取前面的8个元素
        //5.跳过前面的2个元素
        //6.把Stream流中剩余的元素回收到list集合
        //7.遍历打印list集合中的学生对象
         list = list.stream().filter(s -> s.getAge() > 20)
                 .limit(8).skip(2).collect(Collectors.toList());

         list.forEach(System.out::println);
    }
```

