# 1. 简答题

## 简答题一

观察下面的代码，说明代码为什么会报错，如何解决？

![1646735649314](C:\Users\wyk\Desktop\code\javaSE\day7-oop\src\homework\oophight\assets/1646735649314.png)

```java
1.如果子类不是抽象类抽象类必须需要重写父类的所有方法
2.将子类声明成抽象类
```



## 简答题二

观察下面的代码，说明代码为什么会报错，如何解决？

![1646735789785](C:\Users\wyk\Desktop\code\javaSE\day7-oop\src\homework\oophight\assets/1646735789785.png)

```java
没构造方法使用lombok注解
```



## 简答题三

说出继承抽象类、和实现接口需要注意什么？ 没有标准答案，写一个算一个

```java
继承抽象类必须要实现所有的抽象方法
抽象类不能创建对象
一个子类只能继承一个抽象类
一个类可以同时实现多个接口
```



## 简答题四

说出类与类、类与接口、接口与接口的关系?

```java
一个子类只能继承一个父类 
一个类可以实现多个接口
一个接口可以继承多个接口
```



# 2. 编程题

## 编程题一

分析以下需求用代码实现:

```java
1.定义形状类Shape  （考虑这是抽象类、还是接口）
	功能:  求面积,求周长
2.定义圆形类Round: 
	属性:  半径,圆周率
    功能:  求面积,求周长

3.定义长方形类 Rectangle:
	属性:  长和宽
	功能:  求面积,求周长
4.定义测试类:
	分别创建圆形和长方形对象,为相应的属性赋值
	分别调用求面积和求周长的方法
```

```java
public abstract class Shape {


    public abstract double getArea();

    public abstract double getPerimeter();

}
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round extends Shape{

    private double radius;

    private  final double pi=Math.PI;


    @Override
    public double getArea() {
        return pi*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*pi*radius;
    }
}@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape{

    private double width;

    private double height;

    @Override
    public double getArea() {

        return width *  height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
public class ShapeTest {
    public static void main(String[] args) {
        // 创建圆形对象
        Round round = new Round(5.0); // 半径=5
        System.out.println("圆的面积: " + round.getArea());      // 输出: 78.5
        System.out.println("圆的周长: " + round.getPerimeter()); // 输出: 31.4

        // 创建长方形对象
        Rectangle rectangle = new Rectangle(4.0, 6.0); // 长=4，宽=6
        System.out.println("长方形的面积: " + rectangle.getArea());      // 输出: 24.0
        System.out.println("长方形的周长: " + rectangle.getPerimeter()); // 输出: 20.0
    }
}

```



##  编程题二

根据需求完成代码:

```java
1.定义手机类作为父类
 	行为:  打电话，发短信

2.定义接口IPlay
	行为:  玩游戏

3.定义旧手机类继承手机类
	行为：打电话：输出普通的打电话功能
		 发短信：输出普通的发短信功能

4.定义新手机继承手机类，并实现IPlay接口
	行为：
		打电话：输出语句新手机视频通话
		发短信：输出语句新手机发送语音和图片
		玩游戏：输出语句新手机可以玩游戏

5.定义测试类
	在测试类中，创建旧手机对象，调用打电话和发短信的方法。
	在测试类中，创建新手机对象，调用打电话和发短信以及玩游戏的方法
```

```java
public class PhoneTest {
    public static void main(String[] args) {
        // 测试旧手机
        OldPhone oldPhone = new OldPhone();
        oldPhone.call();         // 输出: 普通地打电话功能
        oldPhone.sendMessage();  // 输出: 普通地发短信功能

        // 测试新手机
        NewPhone newPhone = new NewPhone();
        newPhone.call();         // 输出: 新手机视频通话
        newPhone.sendMessage();  // 输出: 新手机发送语音和图片
        newPhone.playGame();     // 输出: 新手机可以玩游戏
    }
}public class NewPhone extends OldPhone implements IPlay{
    @Override
    public void playGame() {
        System.out.println("新手机可以玩游戏");
    }
    @Override
    public void call() {
        System.out.println("新手机可以打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("新手机可以发短信");
    }
}
public class OldPhone extends  Phone{

}public interface IPlay {
    void playGame();
}
public class Phone {
    // 打电话
    public void call() {
        System.out.println("普通的打电话功能");
    }

    // 发短信
    public void sendMessage() {
        System.out.println("普通的发短信功能");
    }
}
```



## 编程题三

按要求完成下面的代码

- 写一个动物类（Animal），有吃东西的方法，但是不知道吃什么东西
- 写一个狗类（Dog），要求它是动物的子类，狗吃骨头
- 写一个猫类（Cat），要求它是动物的子类，猫吃鱼
- 写一个饲养员类（Feeder），要求饲养员有一个饲养任意动物的方法
- 写一个测试类，在测试类中调用Feeder类中的方法，传递Cat对象和Dog对象

```java
public class Animal {
    public void eat(){
        System.out.println("不知道吃什么东西");
    }
}
public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}public class Cat extends  Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
public class Feeder {
    public void feed(Animal animal){
        animal.eat();
    }
}public class FeederTest {
    public static void main(String[] args) {
        Feeder feeder = new Feeder();
        feeder.feed(new Dog());
        feeder.feed(new Cat());
    }
}
```
