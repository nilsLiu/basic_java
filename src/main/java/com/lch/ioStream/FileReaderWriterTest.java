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
        //��hi.txt�ļ����ݶ��뵽�����У������������̨
        FileReader fileReader = null;
        try {
            File file = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt");
            //�ַ���
            fileReader = new FileReader(file);
            //read()�����ض����һ���ַ�������ﵽ�ļ�ĩβ������-1
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
        //���Ĺر�

    }

    @Test
    //��read()����������ʹ��read���ط���
    public void testFileReader1() {
        FileReader fileReader = null;
        try {
            File file = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt");
            //�ַ���
            fileReader = new FileReader(file);
            //read(char[]cbuf):����ÿ�ζ���cbuf�����е��ַ��ĸ���������ﵽ�ļ�ĩβ������-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                //��ʽ1
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

            //�ṩFileWriter�Ķ����������ݵ�д��
            fileWriter = new FileWriter(file, false);

            //д���Ĳ���
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
