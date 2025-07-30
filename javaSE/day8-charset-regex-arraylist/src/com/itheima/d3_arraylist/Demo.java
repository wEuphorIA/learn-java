package com.itheima.d3_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //创建ArrayList集合，保存菜品对象
        ArrayList<Dish> list = new ArrayList<>();

        System.out.println("--------------------欢迎来到黑马餐厅--------------------");
        //1 创建Scanner键盘录入对象
        Scanner sc = new Scanner(System.in);
        //2 循环提示菜品并获取用户的选择
        while (true) {
            System.out.println("请输入您的操作：");
            System.out.println("1、上架菜品\t\t2、查询菜品\t\t3、下架菜品\t\t4、退出系统");
            String choose = sc.next();
            //3 使用switch判断选择，执行对应的语句
            switch (choose) {
                case "1":
                    //System.out.println("上架菜品。。。");
                    addDish(list);  //快捷键：alt+enter--->选择生成方法(create method....)
                    break;
                case "2":
                    //System.out.println("查询菜品。。。");
                    printDish(list);
                    break;
                case "3":
                    System.out.println("下架菜品。。。");
                    removeDish(list);
                    break;
                case "4":
                    System.out.println("正在退出系统，感谢使用！");
                     return;  //结束方法
                default:
                    System.out.println("您的操作有误！");
            }
        }
    }

    /**
     * 下架菜品
     * @param list 保存菜品的集合
     */
    private static void removeDish(ArrayList<Dish> list) {
        //1 创建Scanner键盘录入对象
        Scanner sc = new Scanner(System.in);
        //2 提示并获取用户要删除的菜品名称
        System.out.println("请输入要删除的菜品名称：");
        String name = sc.next();
        //3 遍历集合(倒着)，获取每个菜品对象，通过菜品对象获取菜品名称
        for (int i = list.size() - 1; i >= 0; i--) {
            //4 判断菜品名称和输入的名称是否一样，equals()
            Dish dish = list.get(i);
            if(dish.getName().equals(name)){
                //5 如果一样，就调用集合的remove方法移除菜品。list.remove(i);
                list.remove(i);
                return;
            }
        }
        System.err.println("没有您要删除的菜品!");
    }

    /**
     * 查询并打印所有菜品
     * @param list 保存菜品的集合
     */
    private static void printDish(ArrayList<Dish> list) {
        //判断：如果集合中没有菜品，提示错误信息
        if(list.size()==0){
            System.err.println("还没有菜品，请先上架菜品！");  //error:错误，信息会展示成红色
            return;//不执行后面的代码
        }
        //遍历集合，获取每个菜品并打印
        for (int i = 0; i < list.size(); i++) {
            //根据索引id获取集合中的值
            Dish dish = list.get(i);
            //打印每个菜品
            System.out.println(dish);
        }
    }

    /**
     * 上架菜品
     * @param list 保存菜品的集合
     */
    public static void addDish(ArrayList<Dish> list) {
        //1 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        //2 提示并获取用户输入的菜品信息(菜品名称、菜品价格、菜品描述)
        System.out.println("请输入菜品名称：");
        String name = sc.next();
        System.out.println("请输入菜品价格：");
        double price = sc.nextDouble();
        System.out.println("请输入菜品描述：");
        String desc = sc.next();

        //3 创建dish对象封装上述菜品信息
        Dish dish = new Dish(name, price, desc);

        //4 将dish对象保存到集合中
        list.add(dish);
    }
}
