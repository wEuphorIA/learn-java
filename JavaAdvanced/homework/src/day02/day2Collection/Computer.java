package day02.day2Collection;

import lombok.Data;

import java.util.Objects;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:17
 */
@Data
public class Computer {

    private String brand; // 品牌
    private double price; // 价格
    private String color; // 颜色

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(price, computer.price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(color, computer.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, color);
    }

    public Computer(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }


}
