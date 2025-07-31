package com.itheima.system;

import java.util.ArrayList;
import java.util.Scanner;


/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 上午10:09 */

public class StudentManager {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--------------------欢迎访问黑马学生管理系统--------------------");
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("heima001", "张无忌", 20, "西安"));
        list.add(new Student("heima002", "小昭", 18, "北京"));
        list.add(new Student("heima003", "赵敏", 18, "西安"));
        while (true) {
            System.out.println("1、添加学生\t2、删除学生\t3、修改学生\t4、查看学生\t5、根据学号查询学生\t6、批量删除学生\t7、按其他任意键退出");
            System.out.println("请输入你的选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---------------------------------------------");
                    System.out.println("添加学生");
                    addStudent(list);
                    System.out.println("---------------------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------------------");
                    System.out.println("删除学生");
                    deleteStudent(list);
                    System.out.println("---------------------------------------------");
                    break;
                case 3:
                    System.out.println("---------------------------------------------");
                    System.out.println("修改学生");
                    updateStudent(list);
                    System.out.println("---------------------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------------------");
                    System.out.println("查看学生");
                    printList(list);
                    System.out.println("---------------------------------------------");
                    break;
                case 5:
                    System.out.println("---------------------------------------------");
                    System.out.println("根据学号查询学生");
                    printListById(list);
                    System.out.println("---------------------------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------------------------");
                    System.out.println("批量删除学生");
                    deleteAllStudent(list);
                    System.out.println("---------------------------------------------");
                    break;
                default:
                    System.out.println("感谢使用，再见！");
                    return;
            }
        }

    }

    private static void deleteAllStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息,请添加");
            return;
        }
        System.out.println("请输入要删除的学号：（以,隔开）");
        String[] split = sc.next().split(",");
        for (String id : split) {
            if (isExist(list, id) != -1) {
                list.removeIf(stu -> stu.getId().equals(id));
            } else {
                System.out.println("没有id为" + id + "的学生");
            }
        }

    }

    /**
     @Description: 修改学生
     @param: list
     @return: void
     @author Euphoria
     @date: 2025/7/31 下午12:22
     */

    private static void updateStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息,请添加");
            return;
        }
        System.out.println("请输入要修改的学号：");
        String id = sc.next();
        int s = isExist(list, id);
        if (s != -1) {
            System.out.println("请输入要修改的姓名：");
            String name = sc.next();
            System.out.println("请输入要修改的年龄：");
            int age = sc.nextInt();
            System.out.println("请输入要修改的地址：");
            String address = sc.next();
            list.set(s, new Student(id, name, age, address));
            System.out.println("修改成功");
        } else {
            System.out.println("没有此学生");
        }
        printList(list);
    }

    /**
     @Description: 删除学生
     @param: list
     @return: void
     @author Euphoria
     @date: 2025/7/31 下午12:20
     */

    private static void deleteStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息,请添加");
            return;
        }
        System.out.println("请输入要删除的学号：");
        String id = sc.next();
        boolean b = list.removeIf(stu -> stu.getId().equals(id));
        if (b) {
            System.out.println("删除成功");
        } else {
            System.out.println("没有此学生");
        }
    }

    private static void printListById(ArrayList<Student> list) {
        System.out.println("请输入要查询的学号：");
        String id = sc.next();
        int s = isExist(list, id);
        if (s != -1) {
            System.out.println("查询结果为：");
            System.out.println(list.get(s));
        } else {
            System.out.println("没有此学号对应的学生信息");
        }
    }

    private static void addStudent(ArrayList<Student> list) {
        System.out.println("请输入学生信息：");
        String id; //ctrl + alt + t
        while (true) {
            System.out.println("请输入学生学号(例如：heima001)：");
            id = sc.next();
            if (isExist(list, id) != -1) {
                System.out.println("学号已存在，请重新输入：");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生地址：");
        String address = sc.next();
        Student student = new Student(id, name, age, address);
        list.add(student);
        System.out.println("添加学生成功~");
        printList(list); // 打印更新后的学生列表
    }

    private static void printList(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生信息~");
            return;
        }
        System.out.println("所有学生信息如下：");
        System.out.printf("%-12s%-7s%-4s%-18s%n", "学号", "姓名", "年龄", "地址");
        list.forEach(System.out::println);
    }

    private static int isExist(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
