package day6thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午8:40
 */
public class Practice3 {
    public static void main(String[] args) {
        // 创建线程池（固定2个线程）
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BankAccount bankAccount = new BankAccount();
        for (int i = 0; i < 20; i++) {
            executor.submit(() -> {
                bankAccount.deposit(100, Thread.currentThread().getName());

            });
        }
        executor.shutdown();
    }
}
class BankAccount {
    private int balance = 1000; // 初始余额1000元

    // 同步存钱方法（线程安全）
    public synchronized void deposit(int amount, String threadName) {
        balance += amount;
        System.out.println(threadName + " 存入" + amount + "元后,账户的余额是: " + balance);
    }

    // 查看余额
    public synchronized int getBalance() {
        return balance;
    }
}