package com.itheima.demo6;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午6:21
 */
/*
    需求：
        1 展示系统中的全部电影信息(每部电影展示：名称、评分、导演)。
        2 允许用户根据电影名称查询出某个电影的详细信息。
    分析：
        1 定义一个电影类（Movie类），有名称、评分、导演属性
        2 定义电影系统类（MovieSystem类），创建5个电影对象保存到数组中
        3 定义方法，打印数组中的所有电影信息
        4 定义方法，根据电影名称查询出某个电影信息并打印（比较两个字符串使用字符串的equals（．.）方法）。
 */
    //1 定义一个电影类（Movie类），有名称、评分、导演属性
public class Movie {

    private String name; //名称
    private double score; //评分
    private String director; //导演

    // 构造方法
    public Movie() {
    }

    public Movie(String name, double score, String director) {
        this.name = name;
        this.score = score;
        this.director = director;
    }

    // getter和setter方法

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // toString方法

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
