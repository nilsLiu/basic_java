package com.lch.thread;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-14  16:31
 * @Version: 1.0
 */

/**
 * 使用实现Runnable接口的类
 */

class WindowThread2 implements Runnable {
    private int ticketCount = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketCount > 0) {
                System.out.println(Thread.currentThread().getName() + "售出票号" + ticketCount);
                ticketCount--;
            } else {
                break;
            }
        }
    }
}

public class WindowsTest2 {
    public static void main(String[] args) {
        WindowThread2 windowThread1 = new WindowThread2();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
    }
}
