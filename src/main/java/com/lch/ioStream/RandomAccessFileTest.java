package com.lch.ioStream;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-21  15:09
 * @Version: 1.0
 */

public class RandomAccessFileTest {

    @Test
    public void RandomAccessFileTest1() throws FileNotFoundException {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("object.dat"), "r");
            raf2 = new RandomAccessFile(new File("object1.dat"), "rw");

            byte[] buffer = new byte[1024];
            int len;

            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void RandomAccessFileTest2() throws IOException {

        RandomAccessFile raf1 =
                new RandomAccessFile("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\ioStream\\hi.txt", "rw");
        raf1.seek(3);   //将指针调到角标是3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder =
                new StringBuilder((int) new File("\"D:\\\\idea_project\\\\basic_java\\\\src\\\\main\\\\java\\\\com\\\\lch\\\\ioStream\\\\hi.txt\"").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针，写入
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }
}
