package com.lch.ioStream;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.ioStream
 * @Author: hai
 * @CreateTime: 2023-03-21  14:25
 * @Version: 1.0
 */

public class ObjStreamTest {

    /**
     * 序列化
     * ObjectOutputStream
     */
    @Test
    public void ObjectOutputStreamTest() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("doc/QAQ"));

            oos.flush(); //刷新
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void ObjectInputStreamTest() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }


}
