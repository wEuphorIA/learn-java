package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:28
 */
public class BankAccount {

    private String cardId;

    private int balance;

    private static  int totalAccounts = 0;

    // 可以使用代码块初始化
    //    {
    //        totalAccounts++;  // 开户时总数+1
    //        this.cardId = "BA" + String.format("%04d", totalAccounts);  // 格式化编号
    //        this.balance = 0;  // 新账户余额初始化为0
    //    }

    public BankAccount() {
        totalAccounts++;  // 开户时总数+1
        this.cardId = "BA" + String.format("%04d", totalAccounts);  // 格式化编号
        this.balance = 0;  // 新账户余额初始化为0
    }

    public BankAccount(int balance) {
        this();
        this.balance = balance;
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
