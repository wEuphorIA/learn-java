package com.itheima.d3_xml;

//目标：了解XML文件的语法，能够创建一个XML文件
public class Demo01 {
    public static void main(String[] args) {
        /*
         需求：在当前模块下创建一个students.xml文件,在文件中存储3个学生数据：
                 学号 id：1                   学号 id：2                    学号 id：3
                 姓名 name：张三              姓名 name：李四                姓名 name：王五
                 年龄 age：23                年龄 age：24                   年龄 age：25
                 地址 address：武汉           地址 address：成都             地址 address：西安
            要求：学生数据可以使用student标签存储，其中学号id可以使用属性进行存储
            XML语法规则
               1 XML文件的后缀名为：xml，文档声明必须是第一行，在文件中写一个<箭头就有提示
               2 XML中可以定义注释信息：<!–- 注释内容 -->
               3 XML中的“<标签名>” 称为一个元素，一般是成对出现的，标签名自定义(见名知意)，标签要正确嵌套。
               4 XML中只能由一个根标签，每个标签都可以有0个或者多个属性，属性值必须用引号引起来。
               5 XML中书写”<”、“&”等，可能会出现冲突，导致报错，此时可以用如下特殊字符替代。
               6 XML中可以写一个叫CDATA的数据区: <![CDATA[   …内容…  ]]>，里面的内容会以纯文本的形式体现，也能解决特殊字符冲突问题。
         */

    }
}
