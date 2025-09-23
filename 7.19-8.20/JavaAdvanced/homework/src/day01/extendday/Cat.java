package day01.extendday;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午12:01
 */

public class Cat extends  Animal{


    public Cat(String name) {
       super(name);
    }

    @Override
    public void yell() {
        System.out.println(this.getName() + "：喵喵喵");
    }
}
