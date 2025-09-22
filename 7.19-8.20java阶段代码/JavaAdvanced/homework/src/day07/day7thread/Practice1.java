package day07.day7thread;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/16 下午7:43 */
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