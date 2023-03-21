package com.lch.socket;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.socket
 * @Author: hai
 * @CreateTime: 2023-03-21  16:39
 * @Version: 1.0
 */

/**
 * 例：客户端发送信息到服务端，服务端将数据显示在控制台
 */
public class TCPTest1 {

    @Test
    ///客户端
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.1.1");
            socket = new Socket(inet, 10009);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("I am client".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            //4.资源的关闭
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    //服务端
    public void service() {


        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(10009);

            //2.调用accept()表示接收来自于客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();

            //4.读取输入流当中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源关闭
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
