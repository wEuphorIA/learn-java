package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:02
 */
public class Phone {

    private String brand;

    private String color;

    private int price;

    public Phone() {
    }

    public Phone(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void call(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" +brand + "手机打电话.");
    }

    public void sendMessage(){
        System.out.println("正在使用价格为" + price + "元" + color + "的" +brand + "手机发短信.");
    }


}

