package com.lch.socket;

import org.testng.annotations.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.socket
 * @Author: hai
 * @CreateTime: 2023-03-21  16:03
 * @Version: 1.0
 */

public class InetAddressTest {

    @Test
    public void testInetAddress() {
        try {
            //ip地址
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");
            //域名
            InetAddress inet2 = InetAddress.getByName("www.bilibili.com");
            //本地回路地址，对应localhost
            //127.0.0.1
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            InetAddress inet4 = InetAddress.getLocalHost(); //获取本机地址

            inet2.getHostName(); //获取域名
            inet2.getAddress(); //获取地址

            System.out.println(inet2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
