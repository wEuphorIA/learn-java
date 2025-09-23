package com.itheima.api;

import java.util.Arrays;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 上午11:03
 */
/*
String类的常用方法：
//1.public int length()：获取字符串的长度返回（就是字符个数）
//2.public char charAt(int index)：获取某个索引位置处的字符返回
//3.public char[] toCharArray()：将当前字符串转换成字符数组返回
//4.public boolean equals(Object anObject)：判断当前字符串与另一个字符串的内容一样，一样返回true
//5.public boolean equalsIgnoreCase(String anotherString)：判断当前字符串与另一个字符串的内容是否一样(忽略大小写)
//6.public String substring(int beginIndex, int endIndex)：根据开始和结束索引进行截取，得到新的字符串（包前不包后）
//7.public String substring(int beginIndex)：从传入的索引处截取，截取到末尾，得到新的字符串返回
//8.public String replace(CharSequence target, CharSequence replacement)：使用新值，将字符串中的旧值替换，得到新的字符串
//9.public boolean contains(CharSequence s)：判断字符串中是否包含了某个字符串
//10.public boolean startsWith(String prefix)：判断字符串是否以某个字符串内容开头，开头返回true，反之返回false
//11.public String[] split(String regex)：把字符串按照指定字符串内容进行分割，并返回字符串数组回来
 */
public class Demo2 {
    public static void main(String[] args) {

        //1.public int length()：获取字符串的长度返回（就是字符个数）
        String s = "hello world hello java hello itheima";
        int length = s.length();
        System.out.println("获取字符串的长度返回 = " + length);

        //2.public char charAt(int index)：获取某个索引位置处的字符返回
        char c = s.charAt(0);
        System.out.println("获取某个索引位置处的字符返回 = " + c);

        //3.public char[] toCharArray()：将当前字符串转换成字符数组返回
        char[] chars = s.toCharArray();
        System.out.println("将当前字符串转换成字符数组返回 = " + Arrays.toString(chars));

        //4.public boolean equals(Object anObject)：判断当前字符串与另一个字符串的内容一样，一样返回true
        boolean b = s.equals("abc");
        System.out.println("判断当前字符串与另一个字符串的内容一样，一样返回true = " + b);

        //5.public boolean equalsIgnoreCase(String anotherString)：判断当前字符串与另一个字符串的内容是否一样(忽略大小写)
        boolean b1 = s.equalsIgnoreCase("ABC");
        System.out.println("判断当前字符串与另一个字符串的内容是否一样(忽略大小写) = " + b1);


        //6.public String substring(int beginIndex, int endIndex)：根据开始和结束索引进行截取，得到新的字符串（包前不包后）
        String substring = s.substring(0, 5);
        System.out.println("根据开始和结束索引进行截取，得到新的字符串（包前不包后） = " + substring);

        //7.public String substring(int beginIndex)：从传入的索引处截取，截取到末尾，得到新的字符串返回
        String substring1 = s.substring(5);
        System.out.println("从传入的索引处截取，截取到末尾，得到新的字符串返回 = " + substring1);


        //8.public String replace(CharSequence target, CharSequence replacement)：使用新值，将字符串中的旧值替换，得到新的字符串
        String java = s.replace("java", "C++");
        System.out.println("使用新值，将字符串中的旧值替换，得到新的字符串 = " + java);

        //9.public boolean contains(CharSequence s)：判断字符串中是否包含了某个字符串
        boolean d = s.contains("java");
        System.out.println("判断字符串中是否包含了某个字符串 = " + d);

        //10.public boolean startsWith(String prefix)：判断字符串是否以某个字符串内容开头，开头返回true，反之返回false
        boolean e = s.startsWith("hello");
        System.out.println("以hello开头 = " + e);

        //11.public String[] split(String regex)：把字符串按照指定字符串内容进行分割，并返回字符串数组回来
        String[] split = s.split(" ");
        System.out.println(Arrays.toString( split));
    }
}
