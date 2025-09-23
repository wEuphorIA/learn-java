package homework;

public class Demo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setBrand("小米");
        phone.setColor("黑色");
        phone.setPrice(3998);
        phone.call();
        phone.sendMessage();

        Phone phone1 = new Phone("华为", "蓝色", 5999);
        phone1.call();
        phone1.sendMessage();
    }
}
