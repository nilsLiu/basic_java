package com.lch.thread;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-14  16:22
 * @Version: 1.0
 */

class AThread implements Runnable{

    @Override
    public void run() {
        System.out.println("这是实现Runnable的线程");
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        AThread aThread = new AThread();
        //当前线程的run() -> 调用了Runnable类型的target的run()方法
        new Thread(aThread).start();
    }
}
