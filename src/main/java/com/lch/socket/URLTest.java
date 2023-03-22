package com.lch.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.socket
 * @Author: hai
 * @CreateTime: 2023-03-22  09:43
 * @Version: 1.0
 */

public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.bilibili.com");

            System.out.println(url.getProtocol()); //获取协议号
            url.getHost();  //获取主机号
            url.getPort();  //获取端口号
            url.getPath();  //获取文件路径
            url.getFile();  //获取文件名
            url.getQuery(); //获取查询名
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
