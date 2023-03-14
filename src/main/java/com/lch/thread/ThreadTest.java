package com.lch.thread;


class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("这是MyThread");
    }
}
public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
