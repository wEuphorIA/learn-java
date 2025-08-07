package day03;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 上午12:17 */
public class Practice1 {
    public static void main(String[] args) {
        invokeDirect(() -> System.out.println("导演拍电影啦！"));
    }
    private static void invokeDirect(Director director) {
        director.makeMovie();
    }
}
 interface Director {
    void makeMovie();
}
