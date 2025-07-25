package homework.extendday;




/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午12:03
 */
public class AnimalTest {
    public static void main(String[] args) {
        // 创建动物数组（多态：父类类型引用子类对象）
        Animal[] animals = {
                new Cat("喵星人") ,
                new Dog("旺财")
        };

        for (int i = 0; i < animals.length; i++) {
           animals[i].yell();
        }
    }
}
