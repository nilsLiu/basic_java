package com.lch.reflection.test;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.reflection.test
 * @Author: hai
 * @CreateTime: 2023-03-24  13:32
 * @Version: 1.0
 */

public class Person {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name){
        this.name = name;
    }

    private String nation;

    private String showNation(String nation) {
        System.out.println(name + "-" + nation);
        return nation;
    }

    public void show(){
        System.out.println("Person的public show方法");
    }
}
