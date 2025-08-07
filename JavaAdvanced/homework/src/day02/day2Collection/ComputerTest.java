package day02.day2Collection;

import java.util.HashSet;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:19
 */
public class ComputerTest {
    public static void main(String[] args) {
        HashSet<Computer> computers = new HashSet<>();
        computers.add(new Computer("小米", 5000, "黑色"));
        computers.add(new Computer("华为", 6000, "蓝色"));
        computers.add(new Computer("华为", 6000, "蓝色"));

        computers.forEach(System.out::println);
    }
}
