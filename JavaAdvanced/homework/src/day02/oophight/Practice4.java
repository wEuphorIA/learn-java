package day02.oophight;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午8:49 */
public class Practice4 {
    public static void main(String[] args) {
        // 创建4个Student对象
        Student[] students = {
                new Student("张三", 20, 175.5),
                new Student("李四", 18, 180.0),
                new Student("王五", 20, 170.0),
                new Student("赵六", 19, 165.0)
        };
        // 使用Lambda表达式排序（年龄降序，身高降序）
        Arrays.sort(students,(s1,s2)->{
            if (s1.getAge()!=s2.getAge()){
                return s2.getAge()-s1.getAge();//年龄降序
            }else {
                return Double.compare(s2.getHeight(), s1.getHeight());//身高降序
            }
        });
        System.out.println("按年龄降序如果年龄一样，按照身高降序：");
        System.out.println(Arrays.toString(students));
    }
}
