package day06.day6io.Practice6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/15 下午7:56 */
public class Practice6 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\Practice6\\students.txt"));
        ) {
            String line;
            ArrayList<Student> students = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                students.add(new Student(split[0],Integer.parseInt(split[1])));
            }
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
