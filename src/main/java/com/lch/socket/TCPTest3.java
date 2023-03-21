package com.lch.socket;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.socket
 * @Author: hai
 * @CreateTime: 2023-03-21  17:29
 * @Version: 1.0
 */


import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功"给客户端并关闭相应的连接。
 */
public class TCPTest3 {

    @Test
    public void Client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket("127.0.0.1", 10010);

            os = socket.getOutputStream();

            fis = new FileInputStream(new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\cnn.png"));


            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            //接收来自服务器端的数据

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
    public void Service() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(10010);
            socket = serverSocket.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("cnn_copy.png"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("文件已传输");

            //服务器端给予客户端反馈
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null)
                    fos.close();
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
