package practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午8:50
 */
public class StudentManager {
    public static void main(String[] args) {

        System.out.println("--------------------欢迎访问黑马学生管理系统--------------------");
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查看所有学生");
            System.out.println("5. 查询指定学生");
            System.out.println("6.批量删除学生");
            System.out.println("按其他任意键退出");
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent(students);
                    break;
                case 2:
                    deleteStudent(students);
                    break;
                case 3:
                    System.out.println("修改学生");
                    break;
                case 4:
                    selectStudent(students);
                    break;
                case 5:
                    System.out.println("查询指定学生");
                    break;
                case 6:
                    System.out.println("正在批量删除学生");
                    break;
                default:
                    System.out.println("感谢使用，再见！");
                    return;

            }
        }
    }
    private static void addStudent(ArrayList<Student> list) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号(例如：heima001)：");
        String id = sc.next();
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生地址：");
        String address = sc.next();

        Student student = new Student(id, name, age, address);
        list.add(student);

        System.out.println("添加学生成功~");
    }
    private static void selectStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息~");
        }else {
            System.out.println("所有学生信息如下：");
            list.forEach(System.out::println);
        }
    }
    private static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                list.remove(i);
            }
        }
        System.out.println("删除成功");
    }
    private static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);


    }


}
