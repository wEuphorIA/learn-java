package oophomework.extendday;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午8:44
 */
public class PhoneTest {
    public static void main(String[] args) {

        // 创建 Phone 对象
        Phone phone = new Phone("华为", 3999.99);

        // 打印属性值
        System.out.println("品牌: " + phone.getBrand());
        System.out.println("价格: " + phone.getPrice());
        System.out.println("屏幕尺寸: " + Phone.SIZE); // 直接通过类名访问静态常量

        // 调用方法
        phone.call();
        phone.sendMessage();
        phone.playGame();
    }
}
