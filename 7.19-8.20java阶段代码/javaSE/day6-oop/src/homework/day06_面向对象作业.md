### 练习题一：手机类封装

> 目标：掌握标准JavaBean的书写流程。能够使用无参+set方法去创建对象，给属性赋值。能够掌握有参构造去创建对象

**需求**

1. 定义手机类，手机有品牌(brand),价格(price)和颜色(color)三个属性，有打电话call()和sendMessage()两个功能。
2. 定义测试类，在测试中创建手机对象，使用空参构造创建对象，通过set方法去赋值。或者通过有参构造去创建个对象。
3. 使用对象分别调用call()方法和sendMessage() 方法

程序执行，在控制台输出效果

````java
正在使用价格为3998元黑色的小米手机打电话.
正在使用价格为3998元黑色的小米手机发短信.
````

**考查知识点**：标准JavaBean的制作

**思路分析：**

````java
1.先创建一个手机类Phone，用于封装手机的数据
2.按照标准JavaBean的定义类中的数据：
    2.1 私有成员变量 brand,price , color
    2.2 提供无参构造器和满参构造器
    2.3 提供对应的get/set方法
    2.4 定义一个成员方法(没有static)call()方法，方法中打印 正在使用价格为xxx元xx的xx手机打电话.
    2.5 定义一个成员方法(没有static)sendMessage()方法，方法中打印  正在使用价格为xxx元xx的xx手机发短信.
3.创建一个手机测试类 Demo01
    3.1 先写上一个main方法
    3.2 使用无参构造创建对象【此时对象里面的属性是没有值的】
    3.3 调用对应的set方法去给品牌，价格和颜色赋值
    3.4 调用手机对象的call()方法和sendMessage()方法
    
    3.5 使用满参构造创建对象【此时对象里面的属性是有值的】
    3.6 调用手机对象的call()方法和sendMessage()方法
````

**代码：**

````java
public class Phone {

    private String brand;

    private String color;

    private int price;

    public Phone() {
    }

    public Phone(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void call(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" +brand + "手机打电话.");
    }

    public void sendMessage(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" +brand + "手机发短信.");
    }


}

public class Demo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setBrand("小米");
        phone.setColor("黑色");
        phone.setPrice(3998);
        phone.call();
        phone.sendMessage();

        Phone phone1 = new Phone("华为", "蓝色", 5999);
        phone1.call();
        phone1.sendMessage();
    }
}
````



### 练习题二：学生类封装

**需求：**

1. 定义`Student`类包含私有属性：姓名(name)、年龄(age)、成绩(score)
2. 提供全参构造器、无参构造器
3. 为每个属性提供getter/setter方法，其中年龄范围限制在1-120岁
4. 定义`showInfo()`方法打印学生信息
5. 在main方法中创建两个学生对象并调用showInfo()方法展示信息

**考查知识点：** 封装、this关键字、构造器重载、JavaBean规范

**代码：**

```java
public class Student {

    private String name;

    private int age;

    private int score;



    public Student(String name, int age, int score) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else {
            System.out.println("您赋值的年龄数据非法！");
        }
        this.name = name;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else {
            System.out.println("您赋值的年龄数据非法！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，成绩：" + score);
    }

}
public class Demo2 {
    public static void main(String[] args) {
        Student student1 = new Student("www",18, 100);
        student1.showInfo();
        Student student1 = new Student("www",180, 100);
        student1.showInfo();
    }
}
```



### 练习题三：银行账户管理

**需求：**

1. 创建`BankAccount`类，包含私有属性：账号(id)、余额(balance)
2. 添加静态属性`totalAccounts`记录总账户数
3. 通过构造器实现开户自动生成账号（账号(id)格式：BA0001，BA0002...）
4. 实现存款(deposit)、取款(withdraw)方法，取款时余额不足需提示
5. 在main方法中创建3个账户测试功能

**考查知识点：** static关键字、构造器、方法封装

**代码：**

```java
public class BankAccount {

    private String cardId;

    private int balance;

    private static  int totalAccounts = 0;

    public BankAccount() {
        totalAccounts++;  // 开户时总数+1
        this.cardId = "BA" + String.format("%04d", totalAccounts);  // 格式化编号
        this.balance = 0;  // 新账户余额初始化为0
    }

    public String getCardId() {
        return cardId;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public void deposit(int amount) {
        this.balance += amount;
    }
    public void withdraw(int amount) {
        if (amount > this.balance) {
            System.out.println("余额不足");
        } else {
            this.balance -= amount;
        }
    }
    public void showInfo() {
        System.out.println("卡号：" + this.cardId + "，余额：" + this.balance);
    }
}
public class Demo3 {
    public static void main(String[] args) {
        System.out.println("第一个账户");
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        bankAccount.showInfo();
        System.out.println("第二个账户");
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.deposit(1000);
        bankAccount1.withdraw(800);
        bankAccount1.showInfo();
        System.out.println("第三个账户");
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.deposit(1000);
        bankAccount2.withdraw(1100);
        bankAccount2.showInfo();


    }
}

```



### 练习题四：数学工具类

**需求：**

1. 创建`MathUtils`工具类
2. 包含静态方法：计算数组最大值、最小值、总和、平均值
3. 所有方法接收int数组参数并返回计算结果
4. 禁止实例化该类（构造器私有化）

**考查知识点：** static方法、工具类设计、私有构造器

**代码：**

```java
public class MathUtils {

    // 私有构造器，禁止实例化
    private MathUtils() {
        System.out.println("不能实例化工具类");
    }

    //最大值
    public static int maxArray(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    //最小值
    public static int minArray(int[] arr){
        Arrays.sort(arr);
        return arr[0];
    }
    //数组求和
    public static int sumArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    //数组平均值
    public static double avgArray(int[] arr){
        return sumArray(arr) * 1.0 /arr.length;
    }
}

```



### 练习题五：圆形类设计

**需求：**

1. 创建`Circle`类，包含私有属性：半径(radius)
2. 通过构造器初始化半径，保证半径必须>0，可以不用添加get和set方法。
3. 添加计算周长和面积的方法
4. 创建测试类，在测试类中创建两个圆，获取他们的周长和面积并打印

**考查知识点：** 构造器校验、静态方法、数学计算。

**提示：**

1. Math类型中的常量PI表示数学中的派，使用时用Math.PI即可

**代码：**

```java
public class Circle {

    private double radius;

    public Circle(double radius) {
        if (radius > 0){
            this.radius = radius;
        }
    }

    public double circumference(){
        return 2 * Math.PI * radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }
}
public class Demo4 {
    public static void main(String[] args) {
        System.out.println("第一个圆");
        Circle c1 = new Circle(5.0);
        System.out.println("周长：" + c1.circumference());
        System.out.println("面积：" + c1.area());

        System.out.println("第二个圆");
        Circle c2 = new Circle(10.0);
        System.out.println("周长：" + c2.circumference());
        System.out.println("面积：" + c2.area());

    }
}
```

