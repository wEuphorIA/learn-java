package day01.extendday;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午8:52
 */
public class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // 工作方法（父类定义通用行为）
    public void work() {
        System.out.println("员工正在工作");
    }
}
