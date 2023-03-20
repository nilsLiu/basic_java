package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-20  14:18
 * @Version: 1.0
 */

public class FileReaderWriterTest {

    @Test
    public void testFileReader() {
        //把hi.txt文件内容读入到程序中，并输出到控制台
        FileReader fileReader = null;
        try {
            File file = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt");
            //字符流
            fileReader = new FileReader(file);
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1
//        int data = fileReader.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fileReader.read();
//        }

            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //流的关闭

    }

    @Test
    //对read()操作升级，使用read重载方法
    public void testFileReader1() {
        FileReader fileReader = null;
        try {
            File file = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt");
            //字符流
            fileReader = new FileReader(file);
            //read(char[]cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                //方式1
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);}
                String s = new String(cbuf, 0, len);
                System.out.print(s);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testFileWriter1(){
        FileWriter fileWriter = null;
        try {
            File file = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi2.txt");

            //提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file, false);

            //写出的操作
            fileWriter.write("what\n");
            fileWriter.write("whats up!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
