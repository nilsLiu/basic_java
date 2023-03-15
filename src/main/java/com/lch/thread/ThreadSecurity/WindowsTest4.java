package com.lch.thread.ThreadSecurity;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.ThreadSecurity
 * @Author: hai
 * @CreateTime: 2023-03-15  09:30
 * @Version: 1.0
 */

// 使用同步方法
class WindowThread4 implements Runnable {
    private int ticketCount = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }


    private synchronized void show() { //同步监视器：当前类

        if (ticketCount > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "售出票号" + ticketCount);
            ticketCount--;
        }

    }
}


public class WindowsTest4 {
    public static void main(String[] args) {
        WindowThread4 windowThread1 = new WindowThread4();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
    }
}