package day01.extendday;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: TODO 
 * @author Euphoria
 * @date 2025/7/24 下午9:18
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private String name;

    public void yell() {
        System.out.println("未知叫声");
    }
}
