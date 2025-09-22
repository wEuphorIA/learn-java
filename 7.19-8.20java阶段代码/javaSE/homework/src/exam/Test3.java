package exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午8:25
 */
public class Test3 {
    public static void main(String[] args) {
        String info="10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺#10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖#10004,小昭,女,2023-07-22 08:11:21,东湖#10005,灭绝,女,2023-07-22 17:11:21,归元禅寺";
        // 把这个信息转化成List<student>对象
        List<Student> students = parseStudent(info);
        students.forEach(System.out::println);

        //遍历获得的list集合，统计每个景点选择的次数，并输出景点名称和次数
        Map<String,Integer> map = selectAddressCount( students);

        //查找最多想去的景点，并返回没去这个最多景点的人
        String mostSelectAddress = findMostSelectAddress(map);
        System.out.println("最多选择景点名称："+mostSelectAddress);
        printNoSelectAddress(students,mostSelectAddress); //打印那些人没去这个景点

    }

    private static void printNoSelectAddress(List<Student> students, String mostSelectAddress) {
        students.stream().filter(student -> !student.getSelectAddress().contains(mostSelectAddress))
                .forEach(student -> System.out.println(student.getName()+"没有去"+mostSelectAddress));
    }


    private static String findMostSelectAddress(Map<String, Integer> map) {
        //使用stream流查找出最多选择的景点名称
        return map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getKey();
    }

    public static List<Student> parseStudent(String info){
        String[] students=info.split("#");
        List<Student> list=new ArrayList<>();
        //2023-07-22 11:11:12
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(String student:students){
            String[] studentInfo=student.split(",");
            //10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,东湖-黄鹤楼
            String time=studentInfo[3];
            LocalDateTime localDateTime=LocalDateTime.parse(time,dtf);
            Student s=new Student(Long.parseLong(studentInfo[0]),studentInfo[1],studentInfo[2]
                    ,localDateTime,studentInfo[4]);
            //添加到集合中
            list.add( s);

        }
        return list;
    }

    public static Map<String, Integer> selectAddressCount(List<Student> list){
        Map<String,Integer> map=new HashMap<>();
        for (Student student : list) {
            String selectAddress=student.getSelectAddress();
            //东湖-黄鹤楼
            String[] selectAddressInfo=selectAddress.split("-");
            //遍历每个景点
            for (String selectAddressInfo1 : selectAddressInfo) {
                if(map.containsKey(selectAddressInfo1)){
                    map.put(selectAddressInfo1,map.get(selectAddressInfo1) + 1);
                }else{
                    map.put(selectAddressInfo1,1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("景点名称：" + entry.getKey() + "，出现了" + entry.getValue() + "次");
        }
        return map;
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student{
    private Long id;
    private String name;
    private String sex;
    private LocalDateTime localDateTime;
    private String selectAddress;
}

