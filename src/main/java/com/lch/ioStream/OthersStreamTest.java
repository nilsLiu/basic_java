package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-20  21:50
 * @Version: 1.0
 */

public class OthersStreamTest {

    public static void main(String[] args) {
        //1.Scanner实现，调用next()返回一个字符串

        //2.System.in实现。System.in -> 转换流 -> BufferedReader的readLine()
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);

            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 从键盘翰入字符串，要求将读取到的整行字符串转成大写翰出。然后继续进行翰入操作，
     * 直至当输入“e"或者"exit"时，退出程序。
     */
    @Test
    public void PrintStreamTest() {
        PrintStream ps1 = null;
        try {
            ps1 = new PrintStream("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt");

            ps1.println(100);
            ps1.println('a');
            ps1.println(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps1 != null)
                ps1.close();
        }


    }
}
