package homework.enum1;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午7:47
 */
public class Practice2 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("蜘蛛精", 23, 169.5),
                new Student("紫霞", 26, 163.8),
                new Student("紫霞", 26, 162.8),
                new Student("至尊宝", 24, 167.5)
        };
        // 匿名内部类
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() != o2.getAge()) {
                    return o2.getAge() - o1.getAge();
                }
                return 0;
            }
        });
        System.out.println("按年龄降序（匿名内部类）：");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, (Student o1, Student o2) -> {
            if (o1.getAge() != o2.getAge()) {
                return o2.getAge() - o1.getAge();
            } else {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        });
        System.out.println("按年龄降序如果年龄一样，按照身高降序（Lambda标准格式）：");
        System.out.println(Arrays.toString(students));


        // 3. Lambda简化格式
        Arrays.sort(students, (s1, s2) -> {
            int result = Integer.compare(s2.getAge(), s1.getAge());
            return result != 0 ? result : Double.compare(s2.getHeight(), s1.getHeight());
        });
        System.out.println("按年龄降序如果年龄一样，按照身高降序（Lambda简化）：");
        System.out.println(Arrays.toString(students));
    }
}

