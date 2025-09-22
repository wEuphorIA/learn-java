package day02.oophight;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午9:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round extends Shape{

    private double radius;

    private  final double pi=Math.PI;


    @Override
    public double getArea() {
        return pi*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*pi*radius;
    }
}
