package exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午9:04
 */
public class Test4 {
    public static void main(String[] args) {
        // 1.定义水对象存储每种液体
        // 2.使用List集合存储每种液体对象
        Liquid water = new Liquid("水", 4, 24);
        Liquid milk = new Liquid("牛奶", 8, 160);
        Liquid wine = new Liquid("五粮液", 2, 4000);
        Liquid cola = new Liquid("可乐", 6, 108);
        Liquid maotai = new Liquid("茅台", 1, 4000);
        List<Liquid> list = new ArrayList<>();
        Collections.addAll(list, water, milk, wine, cola, maotai);
        // 3.对List集合按照液体的单价进行降序排序
        list = list.stream().sorted((c1, c2) -> Double.compare(c2.getOnePrice(), c1.getOnePrice())).collect(Collectors.toList());

        // 4.遍历集合，从前往后取10升液体，就是最贵的液体
        double total = 0;
        int all = 10; // 10升
        for (int i = 0; i < list.size(); i++) {
            Liquid liquid = list.get(i);
            // 是否完全达到10升
            int volume = liquid.getVolume();
            if (volume >= all){
                System.out.println(liquid.getName() + "提取了"+all +"升，总价值为：" + liquid.getOnePrice() * all);
                total += liquid.getOnePrice() * all;
                break;
            }else {
                System.out.println(liquid.getName() + "提取了" + volume + "升，总价值为：" + liquid.getOnePrice() * volume);
                total += liquid.getOnePrice() * volume;
                all -= volume;
            }
        }
        System.out.println("总价为：" + total);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Liquid{
    private String name; // 液体名称
    private int volume; // 液体体积
    private int value; // 液体总价值
    // 计算每升价值
    public double getOnePrice() {
        // 精度运输 bigDecimal
        BigDecimal value = BigDecimal.valueOf(this.value);
        BigDecimal volume = BigDecimal.valueOf(this.volume);
        return  value.divide(volume, 2, RoundingMode.HALF_UP).doubleValue();
    }
}
