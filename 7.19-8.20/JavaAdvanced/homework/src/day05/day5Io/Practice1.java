package day5Io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午5:33
 */
public class Practice1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\students.txt");
        ArrayList<Student> students = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null){
                String[] split = line.split(",");
                if (split.length == 2){
                    students.add(new Student(split[0], Integer.parseInt(split[1])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       students.forEach(System.out::println);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{

    private String name;

    private int age;

}