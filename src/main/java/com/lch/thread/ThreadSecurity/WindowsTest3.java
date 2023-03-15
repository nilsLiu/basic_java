package com.lch.thread.ThreadSecurity;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.ThreadSecurity
 * @Author: hai
 * @CreateTime: 2023-03-14  17:24
 * @Version: 1.0
 */

/**
 * 卖票过程中出现了重票、错票 -> 出现了线程的安全问题
 * 原因：当某个线程操作车票的过程中，尚未操作完成，其他线程参与进来，造成安全问题。
 * 解决：当一个线程在操作时，其他线程无法参与进来，直到线程操作完，其他线程才能参与。
 */
class WindowThread3 implements Runnable {
    private int ticketCount = 100;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (WindowThread3.class) {
                if (ticketCount > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + "售出票号" + ticketCount);
                    ticketCount--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowsTest3 {
    public static void main(String[] args) {
        WindowThread3 windowThread1 = new WindowThread3();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
    }
}
