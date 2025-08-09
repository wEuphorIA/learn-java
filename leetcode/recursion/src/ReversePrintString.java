/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 下午6:36 */
//递归反转打印字符串
public class ReversePrintString {
    public static void main(String[] args) {
        f(0,"abcd");
    }
    public static void f( int i,String s){
        if (i == s.length()) return;
        f(i+1,s);
        System.out.println(s.charAt(i));
    }
}
