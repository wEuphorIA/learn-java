package practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午8:50
 */
public class StudentManager1 {
    public static void main(String[] args) {

        System.out.println("--------------------欢迎访问黑马学生管理系统--------------------");
        ArrayList<Student1> student1s = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 添加学生\t2. 删除学生\t3. 修改学生\t4. 查看所有学生\t5. 查询指定学生\t6. 批量删除学生\t按其他任意键退出\t请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent(student1s);
                    break;
                case 2:
                    deleteStudent(student1s);
                    break;
                case 3:
                    updateStudent(student1s);
                    break;
                case 4:
                    selectStudent(student1s);
                    break;
                case 5:
                    queryStudent(student1s);
                    break;
                case 6:
                    batchDeleteStudent(student1s);
                    break;
                default:
                    System.out.println("感谢使用，再见！");
                    return;

            }
        }
    }

    private static void addStudent(ArrayList<Student1> list) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号(例如：heima001)：");
        String id = sc.next();
        if (isExist(list, id)) {
            System.out.println("学号已存在");
            return;
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生地址：");
        String address = sc.next();

        Student1 student1 = new Student1(id, name, age, address);
        list.add(student1);

        System.out.println("添加学生成功~");
    }

    private static void selectStudent(ArrayList<Student1> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息~");
        } else {
            System.out.println("所有学生信息如下：");
            list.forEach(System.out::println);
        }
    }

    private static void deleteStudent(ArrayList<Student1> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        String id = sc.next();
        if (!isExist(list, id)) {
            System.out.println("没有此学生");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
            }
        }
        System.out.println("删除成功");
    }

    private static void updateStudent(ArrayList<Student1> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要更新学生的学号：");
        String id = sc.next();
        if (isExist(list, id)) {
            for (Student1 student1 : list) {
                if (student1.getId().equals(id)) {
                    System.out.println("请输入学生姓名：");
                    String name = sc.next();
                    student1.setName(name);
                    System.out.println("请输入学生年龄：");
                    int age = sc.nextInt();
                    student1.setAge(age);
                    System.out.println("请输入学生地址：");
                    String address = sc.next();
                    student1.setAddress(address);
                    System.out.println("更新成功");
                    System.out.println("更新后的学生" + student1);
                    break;
                }
            }
        } else {
            System.out.println("没有此学生");
        }
    }

    private static void queryStudent(ArrayList<Student1> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学号：");
        String id = sc.next();
        if (!isExist(list, id)) {
            System.out.println("没有这名学生");
        } else {
            System.out.println("查询成功");
        }
    }

    private static boolean isExist(ArrayList<Student1> list, String id) {
        for (Student1 student1 : list) {
            if (student1.getId().equals(id)) {
                System.out.println(student1);
                return true;
            }
        }
        return false;
    }

    private static void batchDeleteStudent(ArrayList<Student1> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要批量删除的学生学号，多个学号使用英文,隔开：");
        String[] ids = sc.next().split(",");
        for (String id : ids) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getId().equals(id)) {
                    list.remove(j);
                    System.out.println("学号" + id + " 删除成功");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("学号" + id + " 不存在");
            }
        }
    }
}
