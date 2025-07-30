package oophomework.extendday;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午8:54
 */
public class Manager extends Employee{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary); // 调用父类构造方法
        this.bonus = bonus;
    }

    // 重写 work 方法
    @Override
    public void work() {
        System.out.printf("工号为%s，姓名叫%s的项目经理月薪%.0f元，奖金%.0f元，他正在汇报项目进度。\n",
                getId(), getName(), getSalary(), bonus);
    }

}
