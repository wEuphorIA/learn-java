package homework.extendday;

import homework.Manager;
import homework.Programmer;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午9:01
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("李飞", "100", 5000);
        programmer.work();
        // 创建项目经理对象
        Manager manager = new Manager("张伟", "26", 30000, 5000);
        manager.work();
    }
}
