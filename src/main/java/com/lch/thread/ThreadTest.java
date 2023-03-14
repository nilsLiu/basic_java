package com.lch.thread;


class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("MyThread1");
        t1.start();

        MyThread t2 = new MyThread("MyThread2");
        t2.start();
        try {
            t2.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
