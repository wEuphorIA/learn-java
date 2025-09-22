package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:53
 */
public class Circle {

    private double radius;

    public Circle(double radius) {
        if (radius > 0){
            this.radius = radius;
        }
    }

    public double circumference(){
        return 2 * Math.PI * radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }
}
