package day05.stream.practice1;

import java.util.HashSet;
import java.util.Set;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午7:56 */
public class Demo1 {
    public static void main(String[] args) {
        Set<Computer> computers = new HashSet<>();

        computers.add(new Computer("Dell", 5999.0, "Silver"));
        computers.add(new Computer("Apple", 12999.0, "Space Gray"));
        computers.add(new Computer("Dell", 5999.0, "Silver"));

        for (Computer c : computers) {
            System.out.println(c);
        }
    }
}
