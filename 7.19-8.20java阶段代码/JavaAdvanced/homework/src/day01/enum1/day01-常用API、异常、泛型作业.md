## 编程题一

**按要求完成代码**

1. 需求：定义Student类（属性：姓名，年龄）（标准JavaBean要求）

2. 创建两个学生对象，都是 "张三"，23
3. 要求1：两个对象在做 equals 比较的时候，方法返回为 true 
4. 要求2：打印学生对象时，打印对象的属性值

**代码：**

```java
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student1 = (Student) o;
        return age == student1.age && Objects.equals(name, student1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Practice1 {
    public static void main(String[] args) {
        Student student1 = new Student(23,"张三");
        Student student1 = new Student(23,"张三");

        System.out.println(student1.equals(student1));
        System.out.println(student1);
        System.out.println(student1);
    }
}
```



## 编程题二

按要求完成下面的代码

1. 准备一个字符串内容如： “20 30 33 55 66 88”
2. 对字符串进行切割，对所有的整数求和，并计算平均值，保留两位小数

```java
public static void main(String[] args) {
        String s = "20 30 33 55 66 88";
        String[] s1 = s.split(" ");
        int sum = 0;
        for (int i = 0; i < s1.length; i++){
            sum += Integer.parseInt(s1[i]);
        }
        System.out.println("这些数的和为" + sum);
        double avg = sum * 1.0 / s1.length;
        System.out.println( "这些数的平均值为" + String.format("%.2f", avg));
    }
```



## 编程题三

需求 :   请键盘录入生日日期(只需要年月日,（如："1998年08月08日"）)，然后计算当前日期距离生日那天间隔多少年？多少月？多少天

**提示：使用LocalDate和Period对象(Period对象自己查资料自学)**

```java
public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日日期（格式：1998年08月08日）：");

        String birthday = scanner.next();
        LocalDate parse = LocalDate.parse(birthday, formatter);
        LocalDate now = LocalDate.now();

        Period period = Period.between(parse, now);

        System.out.printf("距离生日那天间隔%d年%d月%d日", period.getYears(), period.getMonths(), period.getDays());
    }
```



## 编程题四

按下面的步骤完成需求

- 定义一个Student类，有姓名、年龄、身高三个属性

- 在测试类中创建一个Student数组，并创建建4个Student对象，存入数组中

  ```
  "蜘蛛精", 23, 169.5
  "紫霞", 26, 163.8
  "紫霞", 26, 163.8
  "至尊宝", 24, 167.5
  ```

- 使用Arrays的sort方法，对数组中的元素按照年龄降序排列（匿名内部类写法）

- 使用Arrays的sort方法，对数组中的元素按照年龄降序排列，如果年龄一样，按照身高降序（Lambda标准格式）

- 使用Arrays的sort方法，对数组中的元素按照年龄降序排列，如果年龄一样，按照身高降序（Lambda简化格式）

  **【注意：排序规则是两个对象的年龄相减，不是两个对象相减】**

```java
public static void main(String[] args) {
        Student[] student1s = {
                new Student("蜘蛛精", 23, 169.5),
                new Student("紫霞", 26, 163.8),
                new Student("紫霞", 26, 162.8),
                new Student("至尊宝", 24, 167.5)
        };
        // 匿名内部类
        Arrays.sort(student1s, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() != o2.getAge()) {
                    return o2.getAge() - o1.getAge();
                }
                return 0;
            }
        });
        System.out.println("按年龄降序（匿名内部类）：");
        System.out.println(Arrays.toString(student1s));

        Arrays.sort(student1s, (Student o1,Student o2) -> {
            if (o1.getAge() != o2.getAge()) {
                return o2.getAge() - o1.getAge();
            }else {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        });
        System.out.println("按年龄降序如果年龄一样，按照身高降序（Lambda标准格式）：");
        System.out.println(Arrays.toString(student1s));


        // 3. Lambda简化格式
        Arrays.sort(student1s, (s1, s2) -> {
            int result = Integer.compare(s2.getAge(), s1.getAge());
            return result != 0 ? result : Double.compare(s2.getHeight(), s1.getHeight());
        });
        System.out.println("按年龄降序如果年龄一样，按照身高降序（Lambda简化）：");
        System.out.println(Arrays.toString(student1s));
    }
```



