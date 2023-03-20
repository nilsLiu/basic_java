package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-20  15:40
 * @Version: 1.0
 */

public class BufferedTest {
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bfIn = null;
        BufferedOutputStream bfOut = null;

        try {
            File pic1 = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\cnn.png");
            File pic2 = new File("src/main/java/com/lch/ioStream/cnn_copy2.png");
            //�ڵ���
            FileInputStream inputStream = new FileInputStream(pic1);
            FileOutputStream outputStream = new FileOutputStream(pic2);
            //������
            bfIn = new BufferedInputStream(inputStream);
            bfOut = new BufferedOutputStream(outputStream);

            //���Ʋ���
            byte bBuf[] = new byte[5];
            int len;
            while ((len = bfIn.read(bBuf)) != -1) {
                bfOut.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //��Դ�رգ��ȹر����������ٹر��ڲ����
            //�ٹر��������ͬʱ���ڲ���Ҳ���Զ��رգ��ڲ����Ĺرտ���ʡ��
            try {
                if (bfOut != null)
                    bfOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (bfIn != null)
                    bfIn.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
