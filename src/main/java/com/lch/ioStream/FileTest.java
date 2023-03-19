package com.lch.ioStream;

import org.junit.Test;

import java.io.File;

public class FileTest {

    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt"); //相对路径
        File file2 = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch\\hello.txt"); //相对路径
        System.out.println(file1);

        //构造器2
        File file3 = new File("D:\\idea_project\\basic_java\\src\\main\\java\\com\\lch", "hello.txt");

        //构造器3
        File file4 = new File(file3, "hi.txt");
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
    }
}
