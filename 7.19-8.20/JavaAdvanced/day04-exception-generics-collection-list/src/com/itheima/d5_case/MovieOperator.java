package com.itheima.d5_case;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/10 下午4:17 */
public class MovieOperator {
    private final Scanner scanner = new Scanner(System.in);

    private final List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie("唐顿庄园", 9.5, "Tim Allen", 19.9));
        movies.add(new Movie("唐探三", 9.5, "Tim Allen", 19.9));
        movies.add(new Movie("唐顿", 9.5, "Tim Allen", 19.9));
        movies.add(new Movie("唐顿庄", 9.5, "Tim Allen", 19.9));
        movies.add(new Movie("唐顿庄园6", 9.5, "Tim Allen", 19.9));
    }

    public void start() {
        System.out.println("欢迎来到电影管理系统");
        while (true) {
            System.out.println("1. 上架电影 \t 2.下架电影 \t 3.查询电影 \t 4.封杀某明星 \t 5.退出 \t 6.修改电影 \t 7.查询所有电影");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    removeMovie();
                    break;
                case 3:
                    queryMovie();
                    break;
                case 4:
                    removeByActor();
                    break;
                case 5:
                    System.out.println("退出");
                    return;
                case 6:
                    updateMovie();
                    break;
                case 7:
                    queryAllMovie();
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
            }
        }
    }

    private void removeByActor() {
        System.out.println("封杀某明星");
        System.out.println("请输入要封杀的明星名称");
        scanner.nextLine();
        String actor = scanner.nextLine();
        System.out.println("已封杀的明星为：" + actor);
        boolean b = movies.removeIf(movie -> movie.getActor().contains(actor));
        if (b) {
            System.out.println("封杀成功！");
        } else {
            System.out.println("没有找到此明星！");
        }
    }

    private void queryAllMovie() {
        movies.forEach(System.out::println);
    }

    private void updateMovie() {
        System.out.println("修改电影");
        System.out.println("请输入电影名称");
        String name = scanner.next();
        Movie movie = selectMovie(name);
        if (movie != null) {
            System.out.println("请输入新的电影评分");
            double score = scanner.nextDouble();
            System.out.println("请输入新的主演");
            String actor = scanner.next();
            System.out.println("请输入新的电影价格");
            double price = scanner.nextDouble();
            movie.setScore(score);
            movie.setActor(actor);
            movie.setPrice(price);
            System.out.println("修改成功！");
            System.out.println(movie);
        } else {
            System.out.println("没有找到这部电影！");
        }
    }

    private void queryMovie() {
        System.out.println("查询电影");
        System.out.println("请输入电影名称");
        String name = scanner.next();
        selectMovie(name);
    }

    private Movie selectMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                System.out.println(movie.getName() + "电影评分为:" + movie.getScore() + "电影演员：" + movie.getActor() + "电影的价格为" + movie.getPrice());
                return movie;
            }
        }
        System.out.println("没有找到这部电影！");
        return null;
    }

    private void removeMovie() {
        System.out.println("下架电影");
        System.out.println("请输入电影名称");
        String name = scanner.next();
        boolean b = movies.removeIf(movie -> movie.getName().equals(name));
        if (b) {
            System.out.println("下架成功！");
        } else {
            throw new RuntimeException("没有找到这部电影！");
        }
    }

    private void addMovie() {
        System.out.println("上架电影");
        System.out.println("请输入电影名称");
        String name = scanner.next();
        System.out.println("请输入电影评分");
        double score = scanner.nextDouble();
        System.out.println("请输入主演");
        String actor = scanner.next();
        System.out.println("请输入电影价格");
        double price = scanner.nextDouble();
        Movie movie = new Movie(name, score, actor, price);
        movies.add(movie);
        System.out.println("上架成功");
        System.out.println(movie);
        System.out.println("当前电影列表为：" + movies);
    }
}
