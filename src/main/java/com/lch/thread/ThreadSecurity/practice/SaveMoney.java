package com.lch.thread.ThreadSecurity.practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.ThreadSecurity.practice
 * @Author: hai
 * @CreateTime: 2023-03-15  10:30
 * @Version: 1.0
 */

class SaveThread implements Runnable {
    private static int account = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public synchronized void run() {

        for (int i = 1; i <= 3; i++) {
            account += 1000;
            System.out.println(Thread.currentThread().getName() + " account：" + account);
        }
    }

}


public class SaveMoney {
    public static void main(String[] args) {
        SaveThread saveThread = new SaveThread();
        new Thread(saveThread).start();
        new Thread(saveThread).start();

    }
}
