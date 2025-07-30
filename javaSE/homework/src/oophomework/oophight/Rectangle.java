package oophomework.oophight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午9:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape{

    private double width;

    private double height;

    @Override
    public double getArea() {

        return width *  height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
