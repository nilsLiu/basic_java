package com.lch.thread;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-14  16:02
 * @Version: 1.0
 */

/**
 * 三个窗口卖票，一共100张票
 * 使用继承Thread类的方式
 */

class WindowsThread extends Thread {
    private static int ticketsCount = 100;

    @Override
    public void run() {

        while (true) {
            if (ticketsCount > 0) {
                System.out.println(getName() + "票号为" + ticketsCount);
                ticketsCount--;
            } else {
                break;
            }
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {
        WindowsThread windowsThread1 = new WindowsThread();
        WindowsThread windowsThread2 = new WindowsThread();
        WindowsThread windowsThread3 = new WindowsThread();
        windowsThread1.start();
        windowsThread2.start();
        windowsThread3.start();

    }
}
