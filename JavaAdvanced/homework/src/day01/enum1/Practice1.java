package day01.enum1;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午7:39
 */
public class Practice1 {
    public static void main(String[] args) {
        Student student = new Student(23,"张三");
        Student student1 = new Student(23,"张三");

        System.out.println(student.equals(student1));
        System.out.println(student);
        System.out.println(student1);
    }
}
