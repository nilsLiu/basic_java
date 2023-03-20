package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-20  15:16
 * @Version: 1.0
 */

public class FileInputOutputStreamTest {

    @Test
    //实现对图片的复制
    public void testFileInputOutputStream() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File pic1 = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\cnn.png");
            File pic2 = new File("src/main/java/com/lch/ioStream/cnn_copy.png");
            inputStream = new FileInputStream(pic1);
            outputStream = new FileOutputStream(pic2);

            byte bBuf[] = new byte[5];
            int len;
            while ((len = inputStream.read(bBuf)) != -1) {
                outputStream.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
