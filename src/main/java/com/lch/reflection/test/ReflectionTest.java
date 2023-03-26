package com.lch.reflection.test;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.reflection.test
 * @Author: hai
 * @CreateTime: 2023-03-24  13:35
 * @Version: 1.0
 */


public class ReflectionTest {

    //反射后，对类进行操作
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 22);
        Person p = (Person) obj;

        //2.通过反射，调用指定对象的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 20);
        System.out.println(obj.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //3.通过反射，可以调用Person类的私有结构。（私有构造器、方法、属性）
        //调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Nils");
        System.out.println(p1.toString());

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Stephen");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "CN");//相当于 p1.showNation("CN")
        System.out.println(nation);
    }

    //获取Class的实例方法
    @Test
    public void test2() throws ClassNotFoundException {

        //方式1:调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;

        //方式2：通过运行时类的对象,调用getClass()方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();

        //方式3：调用class的静态方法：forName(String classpath)
        Class clazz3 = Class.forName("com.lch.reflection.test.Person");

        //方式4：使用类加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.lch.reflection.test.Person");


        Field[] fields = clazz1.getFields();
        Field[] declaredFields = clazz1.getDeclaredFields();

        for (Field f : declaredFields) {
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));

            Class<?> type = f.getType();
            System.out.println(type + "\t");

            String fName = f.getName();
        }
    }

    @Test
    public void test3() {
        Class<Person> clazz1 = Person.class;

        Method[] methods = clazz1.getMethods();
        for (Method m : methods) {
            System.out.println(methods);

            Annotation[] annotations = m.getAnnotations();
            int modifiers = m.getModifiers();
            Class<?> returnType = m.getReturnType();
            Class<?>[] exceptionTypes = m.getExceptionTypes();
        }
        Method[] declaredMethods = clazz1.getDeclaredMethods();

        Constructor<?>[] constructors = clazz1.getConstructors();
        Constructor<?>[] declaredConstructors = clazz1.getDeclaredConstructors();
        for (Constructor cons : constructors) {
            System.out.println(cons);
        }

        Class<? super Person> superclass = clazz1.getSuperclass();
        Type genericSuperclass = clazz1.getGenericSuperclass();

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        Class<?>[] interfaces = clazz1.getInterfaces();
        Package aPackage = clazz1.getPackage();
        Annotation[] annotations = clazz1.getAnnotations();
    }

    @Test
    public void test4() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //获取指定的属性，要求属性声明为public
        //通常不采用此方法
        Field name = clazz.getField("name");
        //设置当前属性的值
        name.set(p, "mark");

        String pName = (String) name.get(p);

        //获取运行时类指定变量名的属性
        Field name1 = clazz.getDeclaredField("name");
        //保证当前属性是可访问的
        name1.setAccessible(true);

    }

    @Test
    public void test5() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();

        //1.获取指定方法
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(p);
    }
}
