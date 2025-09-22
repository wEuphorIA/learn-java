package oophomework.extendday;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午8:58
 */
public class Programmer extends Employee{

    public Programmer(String name, String id, double salary) {
        super(name, id, salary); // 调用父类构造方法
    }
    @Override
    public void work() {
        System.out.printf("工号为%s，姓名叫%s的程序员月薪%.0f元，他正写代码。\n",
                getId(), getName(), getSalary());
    }
}
