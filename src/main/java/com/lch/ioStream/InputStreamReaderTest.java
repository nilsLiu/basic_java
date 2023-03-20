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
     * ��ʱ�����쳣�Ļ�����ȻӦ��ʹ��try-catch-finally
     * InputStreamReader��ʹ�ã�ʵ���ֽڵ����������ַ�����������ת��
     */
    @Test
    public void test1() throws IOException {

        FileInputStream FIS = new FileInputStream("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\mu.txt");
        //ʹ��ϵͳĬ�ϵ��ַ���
//        InputStreamReader ISR = new InputStreamReader(FIS);
        //����2ָ�����ַ���������ʹ���ĸ��ַ�����ȡ�����ļ�����ʱʹ�õ��ַ���
        InputStreamReader ISR = new InputStreamReader(FIS, "UTF-8");

        char[] cbuf = new char[20];
        int len;
        while ((len = ISR.read(cbuf)) != -1) {
            String s = new String(cbuf, 0, len);
            System.out.println(s);
        }

        //�ر���Դ
        ISR.close();
    }


}
