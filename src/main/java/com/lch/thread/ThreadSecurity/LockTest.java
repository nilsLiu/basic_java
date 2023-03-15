package com.lch.thread.ThreadSecurity;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.ThreadSecurity
 * @Author: hai
 * @CreateTime: 2023-03-15  10:16
 * @Version: 1.0
 */

class Window implements Runnable {

    private int count = 100;

    //实例化lock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //调用锁定方法lock()
                lock.lock();
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "售出" + count);
                    count--;
                }else {
                    break;
                }
            } finally {
                //3.调用unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();
        new Thread(window1).start();
        new Thread(window2).start();
        new Thread(window3).start();
    }
}
