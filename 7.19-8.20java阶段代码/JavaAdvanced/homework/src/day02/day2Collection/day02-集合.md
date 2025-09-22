# 1. 简答题

## 简答题一

* 需求 :  请描述 List 接口 和 Set接口的特点

```
List接口 有序，有重复值 ArrayList LinkedList
Set接口 无序，无重复值  HashSet  LinkedHashSet TreeSet
```



## 简答题二

* 需求 :  请说明,  ArrayList、  LinkedList、HashSet、TreeSet 底层的数据结构及其特点, 

```
ArrayList 底层的数据结构 动态数组 查询快（O(1)） 增删慢 （O(n)）允许重复元素 允许null 自动扩容
LinkedList 底层的数据结构 双向链表 查询慢（O(n)）增删快（O(1)允许重复元素 允许null 自动扩容
HashSet 底层的数据结构 哈希表 查询插入（O(1)）去重，无序，允许null但只有一个
TreeSet  底层的数据结构 红黑树 增删查询O(log n) 不允许null 自动排序
去重

```

## 简答题三

- 需求：请描述TreeSet集合保存自定义对象，定义比较规则的两种方式

```
方式1：让自定义的类实现Comparable接口，重写里面的compareTo方法来指定比较规则。
方式2：通过调用TreeSet集合有参数构造器，可以设置Comparator比较器对象，在比较器中指定比较规则。
比较规则：前面跟后面比，升序；后面跟前面比，降序。
	如果前面元素 >  后面元素，返回任意正整数。
	如果前面元素 <前面元素，返回任意负整数。
	如果前面元素 =前面元素，返回0即可，此时TreeSet集合只会保留一个元素，认为两者重复。
```



# 2. 编程题

## 编程题一

- 需求 :  往ArrayList添加以下元素”abc1”, ”abc2”, ”abc3”, ”abc4”，请使用 4 种遍历方式,  对集合进行遍历

```java
 public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        // 第一种
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------------");

        // 第二种
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("----------------");

        // 第三种
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("----------------");
        // 第四种
        list.forEach(System.out::println);
    }
```



## 编程题二

* 需求 : 往HashSet集合中添加3个电脑对象，要求品牌、价格、颜色相同，就认为是同一个对象，同一个对象只允许存在一个。

```java
@Data
public class Computer {

    private String brand; // 品牌
    private double price; // 价格
    private String color; // 颜色

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(price, computer.price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(color, computer.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, color);
    }

    public Computer(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
 public static void main(String[] args) {
        HashSet<Computer> computers = new HashSet<>();
        computers.add(new Computer("小米", 5000, "黑色"));
        computers.add(new Computer("华为", 6000, "蓝色"));
        computers.add(new Computer("华为", 6000, "蓝色"));

        computers.forEach(System.out::println);
    }
```



## 编程题三

* 需求 :  创建一个电脑类，有品牌、价格、颜色三个属性
* 创建3个电脑对象，往TreeSet集合中添加，并按照价格从高到低进行排序

```java
 public static void main(String[] args) {
        TreeSet<Computer> computers = new TreeSet<>((c1, c2) -> {
            if (c1.getPrice() != c2.getPrice()) {
                return (int) (c2.getPrice() - c1.getPrice()); // 价格降序
            } else {
                return c1.getBrand().compareTo(c2.getBrand()); // 价格相同按品牌排序
            }
        });
        computers.add(new Computer("小米", 5000, "黑色"));
        computers.add(new Computer("华为", 6000, "蓝色"));
        computers.add(new Computer("华为", 6000, "蓝色"));

        computers.forEach(System.out::println);
    }
@Data
public class Computer {

    private String brand; // 品牌
    private double price; // 价格
    private String color; // 颜色

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(price, computer.price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(color, computer.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, color);
    }

    public Computer(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }


}

```



## 编程题四

![1570431176015](assets\1570431176015.png)

**彩票双色球规则**：

1. 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。

2. 红色球号码从1到33中选择；蓝色球号码从1~16中选择。
3. 红色球号码按照从小到大排序。

请结合集合所学知识，随机生成一注双色球号码，**要求同色号码不重复**。

**提示：**

​	**要求同色号码不重复，且号码按照从小到大排序**，对于这个要求使用什么集合存储双色球

**代码：**

```java
public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Random random = new Random();
        while (set.size() < 6) {
            int num = random.nextInt(1,34);
            set.add(num);
        }
        System.out.print("红球：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        int num = random.nextInt(1,17);
        set.add( num);
        System.out.println("蓝球：" + num);

        System.out.println("双色球号码为：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
```
