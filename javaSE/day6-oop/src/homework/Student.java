package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:15
 */
public class Student {

    private String name;

    private int age;

    private int score;



    public Student(String name, int age, int score) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else {
            System.out.println("您赋值的年龄数据非法！");
        }
        this.name = name;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else {
            System.out.println("您赋值的年龄数据非法！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，成绩：" + score);
    }

}
