package com.itheima.d4_case;

import java.util.ArrayList;
import java.util.Scanner;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/30 下午5:36 */
public class FoodManager {
    public static void main(String[] args) {
        //创建一个集合，用于存储菜品信息
        // 创建菜品列表并初始化菜单数据
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("牛排", 18.9, "牛排牛排牛排"));
        dishes.add(new Dish("鱼香肉丝", 12.9, "鱼香肉丝"));

        // 创建用户输入扫描器
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------欢迎来到黑马餐厅-------------------------");

        while (true) {
            System.out.println("请输入您的操作：");
            System.out.println("1、查询菜品 \t 2、上架菜品 \t 3、下架菜品 \t 4、退出系统");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("-----------------------------------");
                    System.out.println("查询菜品");
                    printDish(dishes);
                    System.out.println("-----------------------------------");
                    break;
                case 2:
                    System.out.println("-----------------------------------");
                    System.out.println("上架菜品");
                    addDish(dishes);
                    System.out.println("-----------------------------------");
                    break;
                case 3:
                    System.out.println("-----------------------------------");
                    System.out.println("下架菜品");
                    removeDish(dishes);
                    System.out.println("-----------------------------------");
                    break;
                case 4:
                    System.out.println("-----------------------------------");
                    System.out.println("感谢使用，欢迎下次再来");
                    System.out.println("-----------------------------------");
                    return;
                default:
                    System.out.println("你输入有误！");
            }

        }


    }

    private static void removeDish(ArrayList<Dish> dishes) {
        if (dishes.isEmpty()){
            System.out.println("没有菜品，请先上架菜品！");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要下架的菜品名称：");
        String name = scanner.next();
        boolean b = dishes.removeIf(dish -> dish.getName().equals(name));
        if (b) {
            System.out.println("删除成功！");
        } else {
            System.out.println("没有此菜品！");
        }
        printDish(dishes);
    }

    private static void addDish(ArrayList<Dish> dishes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入菜品名称：");
        String name = scanner.next();
        System.out.println("请输入菜品价格：");
        double price = scanner.nextDouble();
        System.out.println("请输入菜品描述：");
        String desc = scanner.next();
        Dish dish = new Dish(name, price, desc);
        dishes.add(dish);
        System.out.println("添加成功！");
        printDish(dishes);
    }

    private static void printDish(ArrayList<Dish> dishes) {
        if (dishes.isEmpty()) {
            System.out.println("没有菜品，请先上架菜品！");
            return;
        }
        dishes.forEach(System.out::println);
    }

}
