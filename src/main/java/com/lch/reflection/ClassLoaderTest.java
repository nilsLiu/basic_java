package com.lch.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.reflection.test
 * @Author: hai
 * @CreateTime: 2023-03-24  16:24
 * @Version: 1.0
 */

public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类，使用系统加载器加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //AppClassLoader

        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        //ExtClassLoader

        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        //null

    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件方式1
//        FileInputStream fis = new FileInputStream("src/main/resources/jdbc.properties");
//        pros.load(fis);

        //读取配置文件方式2
        //配置文件默认识别在module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user + password);

    }
}
