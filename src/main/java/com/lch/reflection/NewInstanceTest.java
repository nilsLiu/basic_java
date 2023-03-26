package com.lch.reflection;

import com.lch.reflection.test.Person;
import org.junit.Test;

import java.util.Random;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.reflection
 * @Author: hai
 * @CreateTime: 2023-03-24  16:46
 * @Version: 1.0
 */

public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        /*
          newInstance():调用此方法，创建对应的运行时类的对象
         */
        Person p = clazz.newInstance();
    }

    public void test2() {

        new Random().nextInt(3);

    }

    /*
    创建一个指定类的对象
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
