package com.itheima.demo6;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午6:24
 */
//        2 定义电影系统类（MovieSystem类），创建5个电影对象保存到数组中
//        3 定义方法，打印数组中的所有电影信息
//        4 定义方法，根据电影名称查询出某个电影信息并打印（比较两个字符串使用字符串的equals（．.）方法）。
public class MovieSystem类 {
    public static void main(String[] args) {
        //创建5个电影对象保存到数组中
        Movie[] movies = new Movie[5];
        movies[0] = new Movie("唐顿庄园", 9.5, "111");
        movies[1] = new Movie("唐顿庄园2", 9.5, "222");
        movies[2] = new Movie("唐顿庄园3", 9.5, "333");
        movies[3] = new Movie("唐顿庄园4", 9.5, "444");
        movies[4] = new Movie("唐顿庄园5", 9.5, "555");

        printMovie( movies);
        queryMovie(movies, "唐顿庄园6");
    }
    // 3 定义方法，打印数组中的所有电影信息
    public static void printMovie(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }
    }

    // 4 定义方法，根据电影名称查询出某个电影信息并打印（比较两个字符串使用字符串的equals（．.）方法）。
    public static void queryMovie(Movie[] movies, String name) {
        System.out.println("查询结果：");
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().equals(name)) {
                System.out.println(movies[i]);
                return;
            }
        }
        System.out.println("没有找到该电影");
    }
}
