package com.lch.thread;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-15  10:53
 * @Version: 1.0
 */
class BThread implements Runnable {
    private static int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒线程
                notify();
                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "------"+ num);
                    num++;
                    try {
                        //线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class ThreadTest5 {
    public static void main(String[] args) {
        BThread bThread = new BThread();
        new Thread(bThread).start();
        new Thread(bThread).start();

    }
}
