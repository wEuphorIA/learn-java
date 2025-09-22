package com.itheima.d1_network.demo1;

import java.io.IOException;
import java.net.InetAddress;

/**
  InetAddress类：表示ip地址
  常用api：
       static InetAddress getLocalHost()：返回本主机的地址对象
       static InetAddress getByName(String host)：得到指定主机的IP地址对象，参数是域名或者IP地址
       String getHostName()：获取此IP地址的主机名
       String getHostAddress()：返回IP地址字符串
       boolean isReachable(int timeout)：在指定毫秒内连通该IP地址对应的主机，连通返回true
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());

        System.out.println("----------------");

        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        System.out.println(byName.getHostName());
        System.out.println(byName.getHostAddress());
        boolean reachable = byName.isReachable(3000);
        System.out.println(reachable);

    }
}
