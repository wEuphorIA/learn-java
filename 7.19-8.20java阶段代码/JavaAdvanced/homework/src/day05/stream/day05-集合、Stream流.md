## 一、简答题

1、请写出Stream流有哪些中间操作方法，并描述其含义

```java
Stream<T> filter(Predicate<? super T> predicate) 用于对流中的数据进行过滤。
    Stream<T> sorted() 对元素进行升序排序
    Stream<T> sorted (Comparator<? super T> comparator) 按照指定规则排序
    Stream<T> limit (long maxSize) 获取前几个元素
    Stream<T> skip (long n) 跳过前几个元素
    Stream<T> distinct () 去除流中重复的元素。
    <R> Stream<R> map (Function<? super T, ? extends R> mapper) 将流中的T元素转换成R元素，并返回对应的新流。
    static <T> Stream<T> concat (Stream a, Stream b) 合并a和b两个流为一个流
```

2、请写出Stream流有哪些终结操作方法，并描述其含义

```java
void forEach (Consumer action) 对此流运算后的元素执行遍历
    long count () 统计此流运算后的元素个数
    Optional<T> max (Comparator<? super T> comparator) 获取此流运算后的最大值元素
    Optional<T> min (Comparator<? super T> comparator) 获取此流运算后的最小值元素
```

3、请写出Stream流有哪些收集方法，并描述其含义

```java
 R collect (Collector collector) 把流处理后的结果收集到一个指定的集合中去
        Object[] toArray() 把流处理后的结果收集到一个数组中去
    Collectors工具类提供了具体的收集方式
        public static <T> Collector toList () 把元素收集到List集合中 stream.collect(Collectors.toList())
        public static <T> Collector toSet () 把元素收集到Set集合中  stream.collect(Collectors.toSet())
        public static  Collector toMap (Function keyMapper , Function valueMapper) 把元素收集到Map集合中
```



## 二、代码题

### 编程题一

* 需求 : 往HashSet集合中添加3个电脑对象，要求品牌(brand)、价格(price)、颜色相同(color)，就认为是同一个对象，同一个对象只允许存在一个。

```java
//定义Computer类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    private String brand;
    private double price;
    private String color;
}

```

```java
//测试类
public class Demo01 {
    public static void main(String[] args) {
		Set<Computer> computers = new HashSet<>();

        // 添加3个电脑对象（其中两个属性相同）
        computers.add(new Computer("Dell", 5999.0, "Silver"));
        computers.add(new Computer("Apple", 12999.0, "Space Gray"));
        computers.add(new Computer("Dell", 5999.0, "Silver"));

        // 遍历打印（应只保留两个对象）
        for (Computer c : computers) {
            System.out.println(c);
        }
    }
}
```



### 编程题二

<img src="assets\1570431176015.png" alt="1570431176015" style="zoom: 200%;" />

**彩票双色球规则**：

1. 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。

2. 红色球号码从1到33中选择；蓝色球号码从1~16中选择。
3. 红色球号码按照从小到大排序。

请结合集合所学知识，随机生成一注双色球号码，**要求同色号码不重复**。

**提示：**

​	**要求同色号码不重复，且号码按照从小到大排序**，对于这个要求使用什么集合存储双色球

**代码：**

```java
public class Demo02 {
    public static void main(String[] args) {
		Random random = new Random();

        TreeSet<Integer> set = new TreeSet<>();
        while (set.size() < 6){
            int red = random.nextInt(1, 34);
            set.add(red);
        }
        int blue = random.nextInt(1, 17);
        System.out.print("红球：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println("蓝球：" + blue);
    }
}
```

### 编程题三

需求 :  有一个"helloworldjava"字符串,统计该字符串中各个字符的数量，例如程序输出结果：

- h-1 e-1 l-3 o-2 w-1 r-1 d-1 j-1 a-2 v-1   （顺序不做要求）

```java
public class Demo03 {
    public static void main(String[] args) {
		String s = "helloworldjava";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        map.forEach((k,v)-> System.out.print(k + "=" + v +" "));
    }
}
```

### 编程题四

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
public class Demo04 {
    public static void main(String[] args) {
		Integer[] arr = {123,456,777,345,345,222,999,222,110,120,567};
        Arrays.stream(arr).sorted((o1, o2) -> o2-o1).limit(8).skip(3)
                .distinct().filter(a -> a%2==0).forEach(System.out::println);
    }
}
```



### 编程题五

按要求完成下面的需求

1. 创建一个Student类，有name和age两个属性，生成构造器、get、set、toString等方法（可以使用lambok工具）

2. 创建一个测试类，请基于下面代码按要求完成代码

```java
import java.util.Collections;

public class Demo05 {
    public static void main(String[] args) {
          //准备好一个集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"金毛狮王","周芷若", "周芷若","张无忌","灭绝师太","灭绝师太","张三丰", "张翠山", "小昭", "赵敏");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杨过","小龙女","张三丰", "张翠山", "小昭", "赵敏");

        //1.获取两个集合的流，将两个流合并为一个流
        Stream<String> concat = Stream.concat(list1.stream(), list2.stream());

        //2.过滤姓名长度大于2的元素、截取前面8个、跳过前面1个、去重重复元素
        Random random = new Random();
        concat.filter(s -> s.length() > 2).limit(8).skip(1).distinct().map(name -> new Student( name,random.nextInt(18,101))).forEach(System.out::println);
        //3 将Stream流中的字符串名字转换成Student对象，对象的年龄取[18,100]之间的随机整数，转换完成之后遍历打印。
    }
}
```



### 编程题六

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
public class Demo06 {
    public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
        list.add(new Student("张三",20));
        list.add(new Student("李四",18));
        list.add(new Student("王五",19));
        list.add(new Student("赵六",25));
        list.add(new Student("王炸",28));
        list.add(new Student("小王",26));
        list.add(new Student("大王",24));
        list.add(new Student("蘑菇头",23));
        list.add(new Student("妹爷",29));
        list.add(new Student("老王",30));
        list.add(new Student("老李",22));

        List<Student> collect = list.stream().filter(s -> s.getAge() > 20).limit(8).skip(2).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
```

