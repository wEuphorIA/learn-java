package day6thread;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午8:24
 */
public class Practice1 {
    public static void main(String[] args) {
        // 1、创建Runnable接口的实现类对象
        MyRunnable myRunnable = new MyRunnable();
        // 3、创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread t = new Thread(myRunnable);
        // 4、调用start方法开启多线程
        t.start();
        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
class MyRunnable implements Runnable {
    // 2、重写run方法，设置线程任务
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
