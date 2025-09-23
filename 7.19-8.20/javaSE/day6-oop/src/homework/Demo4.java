package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:58
 */
public class Demo4 {
    public static void main(String[] args) {
        System.out.println("第一个圆");
        Circle c1 = new Circle(5.0);
        System.out.println("周长：" + c1.circumference());
        System.out.println("面积：" + c1.area());

        System.out.println("第二个圆");
        Circle c2 = new Circle(10.0);
        System.out.println("周长：" + c2.circumference());
        System.out.println("面积：" + c2.area());



    }
}
