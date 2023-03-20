package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-20  21:01
 * @Version: 1.0
 */

public class InputStreamReaderTest {

    /**
     * 此时处理异常的话，仍然应该使用try-catch-finally
     * InputStreamReader的使用，实现字节的输入流到字符的输入流的转树
     */
    @Test
    public void test1() throws IOException {

        FileInputStream FIS = new FileInputStream("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\mu.txt");
        //使用系统默认的字符集
//        InputStreamReader ISR = new InputStreamReader(FIS);
        //参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
        InputStreamReader ISR = new InputStreamReader(FIS, "UTF-8");

        char[] cbuf = new char[20];
        int len;
        while ((len = ISR.read(cbuf)) != -1) {
            String s = new String(cbuf, 0, len);
            System.out.println(s);
        }

        //关闭资源
        ISR.close();
    }


}
