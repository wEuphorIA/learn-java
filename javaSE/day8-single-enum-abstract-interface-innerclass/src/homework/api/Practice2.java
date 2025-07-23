package homework.api;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午6:18
 */
public class Practice2 {
    public static void main(String[] args) {
        String s = "peter piper picked a peck of pickled peppers";
        int count = 0;
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].contains("p") ) {
                count++;
            }
        }
        System.out.println("以 'p' 开头的单词总数: "  + count);
    }
}
