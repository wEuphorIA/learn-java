package day02.oophight;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午9:08
 */
public class ShapeTest {
    public static void main(String[] args) {
        // 创建圆形对象
        Round round = new Round(5.0); // 半径=5
        System.out.println("圆的面积: " + round.getArea());      // 输出: 78.5
        System.out.println("圆的周长: " + round.getPerimeter()); // 输出: 31.4

        // 创建长方形对象
        Rectangle rectangle = new Rectangle(4.0, 6.0); // 长=4，宽=6
        System.out.println("长方形的面积: " + rectangle.getArea());      // 输出: 24.0
        System.out.println("长方形的周长: " + rectangle.getPerimeter()); // 输出: 20.0
    }
}
