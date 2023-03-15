package com.lch.thread.ThreadSecurity.practice2;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.ThreadSecurity.practice2
 * @Author: hai
 * @CreateTime: 2023-03-15  11:22
 * @Version: 1.0
 */

class Clerk {

    int count = 0;

    public synchronized void produce() {
        if (count < 20) {
            count++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + count + "个");
            notify();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consume() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "开始销售产第" + count + "个");
            count--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class pThread implements Runnable {
    private Clerk clerk;

    public pThread(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public synchronized void run() {
        System.out.println("现在开始生产产品");
        while (true){
            clerk.produce();
        }
    }
}


class cThread implements Runnable {
    private Clerk clerk;

    public cThread(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public synchronized void run() {
        System.out.println("现在开始销售产品");
        while (true) {
            clerk.consume();

        }

    }
}

public class market {


    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        pThread pThread = new pThread(clerk);
        Thread thread1 = new Thread(pThread);
        thread1.setName("生产者");

        cThread cThread = new cThread(clerk);
        Thread thread2 = new Thread(cThread);
        thread2.setName("消费者");

        thread1.start();
        thread2.start();
    }
}
