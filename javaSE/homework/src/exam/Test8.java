package exam;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午4:49 */
public class Test8 {

    public static void main(String[] args) {
        ArrayList<Phone> list_phone = new ArrayList<>();
        list_phone.add(new Phone("小米MIX2", 2999, "新机皇"));
        list_phone.add(new Phone("Iphone8", 5888, "火爆新机"));
        list_phone.add(new Phone("VIVO X9s", 1998, "火爆新机"));

        ArrayList<Phone> filteredList = filter(list_phone, 2000);
        System.out.println("返回的list集合中的所有元素信息：");
        for (Phone p : filteredList) {
            System.out.println(p.getName() + " " + p.getPrice() + " " + p.getType());
        }
    }
    public static ArrayList<Phone> filter(ArrayList<Phone> list, double price) {

        return (ArrayList<Phone>) list.stream().filter(s -> s.getPrice() > price).collect(Collectors.toList());
    }
}
class Phone {
    private String name;
    private double price;
    private String type;

    public Phone() {}
    public Phone(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getType() { return type; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setType(String type) { this.type = type; }
}