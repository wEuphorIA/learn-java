package day2Collection;

import java.util.TreeSet;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:27
 */
public class ComputerTest1 {
    public static void main(String[] args) {
        TreeSet<Computer> computers = new TreeSet<>((c1, c2) -> {
            if (c1.getPrice() != c2.getPrice()) {
                return (int) (c2.getPrice() - c1.getPrice()); // 价格降序
            } else {
                return c1.getBrand().compareTo(c2.getBrand()); // 价格相同按品牌排序
            }
        });
        computers.add(new Computer("小米", 5000, "黑色"));
        computers.add(new Computer("华为", 6000, "蓝色"));
        computers.add(new Computer("华为", 6000, "蓝色"));

        computers.forEach(System.out::println);
    }
}
