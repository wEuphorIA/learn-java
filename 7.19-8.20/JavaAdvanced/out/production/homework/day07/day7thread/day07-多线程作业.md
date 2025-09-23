# 1、简答题

## 简答题一

- 简述创建多线程的几种方式以及各自的优缺点

```html
  - 继承Thread 
  - 实现Runnable
  - 实现Callable
继承Thread  简单 没返回值可扩展性强
实现Runnable 可扩展性强 没返回值
实现Callable 有返回值 实现复杂
```

## 简答题二

- 简述线程安全问题出现的原因以及解决方案

```html
多个线程同时修改一个共享资源
```

## 简答题三

- 简述ThreadPoolExecutor构造器的7个参数的含义

```html
  - corePoolSize 核心线程数（长期保留的线程）。
  - maximumPoolSize最大线程数（核心线程 + 临时线程）。
  - keepAliveTime临时线程的空闲存活时间（超时回收）。
  - unit keepAliveTime的时间单位（如 TimeUnit.SECONDS）。
  - workQueue任务队列（如 LinkedBlockingQueue、ArrayBlockingQueue）。
  - threadFactory线程工厂（自定义线程名称、优先级等）。
  - handler拒绝策略（当队列和线程池均满时的处理方式）。
```





# 2、编程题

## 编程题一

**需求：**

- 请使用实现Runnable接口的方式定义一个任务类，在run()方法中循环打印1--1000所有的数字。
- 定义main()方法，创建子线程执行上述任务，然后在主线程中, 循环打印1--1000所有的数字。
- 打印的时候要带有线程名字, 使用默认名称即可。
- 请观察控制台打印，打印的情况

**代码：**

```java
public class Practice1 {
    public static void main(String[] args) {
        new Thread(new MyRunable()).start();
        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
class MyRunable implements  Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
```

## 编程题二

**需求：**

- 使用ThreadPoolExecutor创建一个线程池，要求核心线程数3个，最大线程数6个，任务队列长度为10，临时线程存活时间为5秒；
- 要求给7个参数加上注释
- 在使用创建好的线程池，提交16个任务
- 每一个任务打印线程名称，和任务编号（参考老师写的代码）

**代码：**

```java
public class Practice2 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数
                6,//最大线程数
                5L,//临时线程存活时间
                TimeUnit.SECONDS,//临时线程存活单位
                new LinkedBlockingDeque<>(10),//任务队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyRunable1 myRunable1 = new MyRunable1();
        for (int i = 0; i < 16; i++) {
            pool.execute(myRunable1);
        }
        pool.shutdown();
    }
}
class MyRunable1 implements  Runnable{
    int i = 1;

    @Override
    public synchronized void run() {

        System.out.println("第" + i + "个任务" + " | 执行线程: " + Thread.currentThread().getName());
        i++;
    }
}
```

## 编程题三

**需求：**

本案例模拟一个简单的银行系统,使用两个不同的线程向同一个账户存钱。账户的初始余额是1000元，两个线程每次存储100元，分别各存储1000元，不允许出现错误数据，程序运行结果如下图所示：存的顺序随机。

```
pool-1-thread-1 存入100元后,账户的余额是: 1100
pool-1-thread-1 存入100元后,账户的余额是: 1200
pool-1-thread-1 存入100元后,账户的余额是: 1300
pool-1-thread-1 存入100元后,账户的余额是: 1400
pool-1-thread-1 存入100元后,账户的余额是: 1500
pool-1-thread-2 存入100元后,账户的余额是: 1600
pool-1-thread-2 存入100元后,账户的余额是: 1700
pool-1-thread-2 存入100元后,账户的余额是: 1800
pool-1-thread-2 存入100元后,账户的余额是: 1900
pool-1-thread-2 存入100元后,账户的余额是: 2000
pool-1-thread-2 存入100元后,账户的余额是: 2100
pool-1-thread-2 存入100元后,账户的余额是: 2200
pool-1-thread-2 存入100元后,账户的余额是: 2300
pool-1-thread-2 存入100元后,账户的余额是: 2400
pool-1-thread-2 存入100元后,账户的余额是: 2500
pool-1-thread-1 存入100元后,账户的余额是: 2600
pool-1-thread-1 存入100元后,账户的余额是: 2700
pool-1-thread-1 存入100元后,账户的余额是: 2800
pool-1-thread-1 存入100元后,账户的余额是: 2900
pool-1-thread-1 存入100元后,账户的余额是: 3000
```

**要求：**使用线程池完成

**提示：**

1. 需要定义一个公共的账户类，成员变量int balance表示余额，提供存钱和查看余额的方法。

**代码：**

```java
public class Practice3 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,//核心线程数
                2,//最大线程数
                0L,//临时线程存活时间
                TimeUnit.SECONDS,//临时线程存活单位
                new LinkedBlockingDeque<>(10),//任务队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyRunable2 myRunable2 = new MyRunable2();
        pool.execute(myRunable2);
        pool.execute(myRunable2);
        pool.shutdown();
    }
}
class MyRunable2 implements  Runnable{
    int count = 1000;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            count = count +100;
            System.out.println(Thread.currentThread().getName() + " 存入100元后,账户的余额是: " + (count));
        }
    }
}
```



## 编程题四【选做】

**需求：**

某房产公司大促销,所有购房者可以参加一次抽奖，抽奖箱中总共有10个奖品,分别是:"**苹果手机","华为手机","三洋踏板摩托","迪拜7日游","苹果笔记本","联想笔记本","小米空气净化器","格力空调","海尔冰箱","海信电视"**，以上奖品用集合存储，所有抽奖者分成两组进行抽奖，请使用创建两个线程，名称分别为“**第1组**”和“**第2组**”，随机从抽奖箱中完成抽奖。
程序运行效果如下图：不要求轮流打印，不要求平均分配抽奖次数，也就是随机。

```

```

**要求：**可以自己创建线程对象，也可以使用线程池完成，使用线程池做会麻烦一些。

**提示：**线程池中的线程有默认的名称，要想修改线程池中线程的名称需要自定义线程工厂，可以AI搜索："在Java中，如果修改线程池中线程的名称?"

**代码：**

- 不使用线程池

```java
public class Practice5 {
    public static final List<String> prizes = Arrays.asList(
            "苹果手机", "华为手机", "三洋踏板摩托", "迪拜7日游", "苹果笔记本",
            "联想笔记本", "小米空气净化器", "格力空调", "海尔冰箱", "海信电视"
    );

    public static void main(String[] args) {
        // 1. 创建抽奖箱（使用同步集合）
        List<String> lotteryBox = Collections.synchronizedList(new ArrayList<>(prizes));

        Thread thread1 = new Thread(() -> {
            drawPrize(lotteryBox, "第一组");
        },"第一组");
        Thread thread2 = new Thread(() -> {
            drawPrize(lotteryBox, "第组");
        },"第二组");

        thread1.start();
        thread2.start();
    }
    private static void drawPrize(List<String> box, String groupName) {
        Random random = new Random();
        while (!box.isEmpty()) {
            synchronized (box) {  // 加锁保证抽奖原子性
                if (!box.isEmpty()) {
                    int index = random.nextInt(box.size());
                    String prize = box.remove(index);
                    System.out.println(groupName + " 抽中了: " + prize);
                }
            }
            try {
                Thread.sleep(500); // 模拟抽奖间隔
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

- 使用线程池

```java
public class Practice4 {

    private static final List<String> prizes = Arrays.asList(
            "苹果手机", "华为手机", "三洋踏板摩托", "迪拜7日游", "苹果笔记本",
            "联想笔记本", "小米空气净化器", "格力空调", "海尔冰箱", "海信电视"
    );
    public static void main(String[] args) {
        // 1. 创建自定义线程工厂（设置线程名称）
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger groupNum = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "第" + groupNum.getAndIncrement() + "组");
            }
        };

        // 2. 创建线程池（固定2个线程）
        ExecutorService executor = Executors.newFixedThreadPool(2, threadFactory);

        // 3. 创建抽奖箱（线程安全的集合）
        List<String> lotteryBox = new CopyOnWriteArrayList<>(prizes);

        // 4. 提交抽奖任务（模拟10次抽奖）
        for (int i = 1; i <= 10; i++) {
            executor.submit(() -> {
                if (!lotteryBox.isEmpty()) {
                    // 随机抽取一个奖品
                    int index = new Random().nextInt(lotteryBox.size());
                    String prize = lotteryBox.remove(index);
                    System.out.println(Thread.currentThread().getName() + " 抽中了: " + prize);
                }
            });
        }

        // 5. 关闭线程池
        executor.shutdown();
    }
}

```

