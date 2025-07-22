package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:37
 */
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
