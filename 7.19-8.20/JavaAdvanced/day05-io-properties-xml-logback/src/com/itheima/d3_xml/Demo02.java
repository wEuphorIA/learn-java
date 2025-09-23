package com.itheima.d3_xml;

//目标：掌握使用dom4j解析xml文件的api
public class Demo02 {
    public static void main(String[] args){
        /*
          dom4j获取解析器、Document文档、根标签对象的API：
               public SAXReader()：创建Dom4j的解析器对象
               Document read(String url)：加载xml文件成为Document对象
               Element getRootElement()：获得根元素对象
         
          dom4j解析xml标签、属性、文本的API：
               List<Element> elements()：得到当前元素下所有子元素
               List<Element> elements(String name)：得到当前元素下指定名字的子元素返回集合
               Element element(String name)：得到当前元素下指定名字的子元素,如果有很多名字相同的返回第一个
               String getName()：得到元素名字
               String  attributeValue(String name)：通过属性名直接得到属性值
               String elementText(子元素名)：得到指定名称的子元素的文本
               String getText()：得到文本
         */
    }
}
