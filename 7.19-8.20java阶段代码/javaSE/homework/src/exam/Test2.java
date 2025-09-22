package exam;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午9:11
 */
public class Test2 {
    public static void main(String[] args) {
        // 创建一个arrayList集合放囚犯
        ArrayList<Prisoner> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++){
            int code = random.nextInt(1, 201); //随机编号
            // 判断编号是否重复
            if (isRepeat(list, code)){
                //重复了
                i--;
                continue;
            }
            Prisoner prisoner = new Prisoner(code,i);
            list.add(prisoner);
        }

        System.out.println(list);
        // 2.去掉集合中奇数位置的 prison 直到剩下最后一个人
        while (true){
            //定义一个新集合存储本轮被去掉后剩下的囚犯
            ArrayList<Prisoner> lastPrisoners = new ArrayList<>();
            for (int i = 1; i < list.size(); i+=2) {
                lastPrisoners.add(list.get(i));
            }
            if (lastPrisoners.size() == 1){
                Prisoner prisoner = lastPrisoners.get(0);
                System.out.println("最后剩下的囚犯的编号：" + prisoner.getId() +"最开始的位置："+ prisoner.getFirstLocation());
                break;
            }
            list = lastPrisoners; //剩余的囚犯交给下一轮
            System.out.println(lastPrisoners);
        }
    }

    public static boolean isRepeat(ArrayList<Prisoner> list, int code){
        for (Prisoner p : list){
            if (p.getId() == code){
                return true; //存在重复
            }
        }
        return false;
    }
}
// 定义一个囚犯类，封装随机编号，和第一次站的位置
@Data
@AllArgsConstructor
@NoArgsConstructor
class Prisoner{
    private int id;
    private int firstLocation;

}