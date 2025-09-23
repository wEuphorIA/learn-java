package com.itheima.d3_regex;

/*
目标：演示正则表达式的书写规则
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1、字符类(只能匹配单个字符)
		//说明：带 [内容] 的规则都只能用于匹配单个字符，不能匹配多个字符
        // [abc] 只能匹配a、b、c
        System.out.println("----------[abc] 只能匹配a、b、c-----------");
        System.out.println("b".matches("[abc]"));    // true
        System.out.println("d".matches("[abc]"));   // false
		System.out.println("ab".matches("[abc]")); // false

        //[^abc] 不能是a、b、c
        System.out.println("----------[^abc] 不能是a、b、c-----------");
        System.out.println("d".matches("[^abc]"));   //true
        System.out.println("中".matches("[^abc]"));   //true
        System.out.println("a".matches("[^abc]"));  // false

        //[a-zA-Z] 只能是a-z A-Z的字符
        System.out.println("----------[a-zA-Z] 只能是a-z A-Z的字符-----------");
        System.out.println("b".matches("[a-zA-Z]")); // true
        System.out.println("2".matches("[a-zA-Z]")); // false

        
  

        // 2、预定义字符(只能匹配单个字符)  .  \d  \w 
        // . 可以匹配任意一个字符
        System.out.println("----------. 可以匹配任意一个字符-----------");
        System.out.println("周".matches(".")); // true
        System.out.println("周周".matches(".")); // false

        // \转义
        System.out.println("---------- \\ 表示转义-----------");
        System.out.println("\"");

        // \d 表示数字，等价于[0-9]
        System.out.println("---------- \\d 表示数字，等价于[0-9]-----------");
        System.out.println("3".matches("\\d"));  //true
        System.out.println("a".matches("\\d"));  //false
		
        //  \w 表示字母、数字、或下划线，等价于[a-zA-Z_0-9]
        System.out.println("---------- \\w 表示字母、数字、或下划线，等价于[a-zA-Z_0-9]-----------");
        System.out.println("a".matches("\\w"));  // true
        System.out.println("_".matches("\\w")); // true
        System.out.println("周".matches("\\w")); // false
		System.out.println("23232".matches("\\d")); // false 注意：以上预定义字符都只能匹配单个字符。

        // 3、数量词： ?   *   +   {n}   {n, }  {n, m}
        System.out.println("---------- 3、数量词： ?  -----------");
        System.out.println("a".matches("\\w?"));   // true ? 代表0次或1次
        System.out.println("".matches("\\w?"));    // true
        System.out.println("abc".matches("\\w?")); // false

        System.out.println("---------- 3、数量词：  *  -----------");
        System.out.println("abc12".matches("\\w*"));   // true * 代表0次或多次
        System.out.println("".matches("\\w*"));        // true
        System.out.println("abc12周".matches("\\w*")); // false

        System.out.println("---------- 3、数量词：  +  -----------");
        System.out.println("abc12".matches("\\w+"));   // true + 代表1次或多次
        System.out.println("".matches("\\w+"));       // false
        System.out.println("abc12周".matches("\\w+")); // false

        System.out.println("---------- 3、数量词：  {n}   {n, }  {n, m}  -----------");
        System.out.println("a3c".matches("\\w{3}"));   // true {3} 代表要正好是n次
        System.out.println("abcd".matches("\\w{3}"));  // false
        System.out.println("abcd".matches("\\w{3,}"));     // true {3,} 代表是>=3次
        System.out.println("ab".matches("\\w{3,}"));     // false
        System.out.println("abcde周".matches("\\w{3,}"));     // false
        System.out.println("abc232d".matches("\\w{3,9}"));     // {3, 9} 代表是  大于等于3次，小于等于9次

        // 4、其他几个常用的符号：或：| 、  分组：()
        // 需求1：要求要么是3个小写字母，要么是3个数字。
        System.out.println("-------需求1：要求要么是3个小写字母，要么是3个数字。-------");
        System.out.println("abc".matches("[a-z]{3}|\\d{3}")); // true
        System.out.println("ABC".matches("[a-z]{3}|\\d{3}")); // false
        System.out.println("123".matches("[a-z]{3}|\\d{3}")); // true
        System.out.println("A12".matches("[a-z]{3}|\\d{3}")); // false

        // 需求2：必须是”我爱“开头，中间可以是至少一个”编程“，最后至少是1个”666“
        System.out.println("-------需求2：必须是”我爱“开头，中间可以是至少一个”编程“，最后至少是1个”666“。-------");
        System.out.println("我爱编程编程666666".matches("我爱(编程)+(666)+"));
        System.out.println("我爱编程编程66666".matches("我爱(编程)+(666)+"));
    }
}
