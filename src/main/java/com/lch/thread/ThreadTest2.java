package com.lch.thread;

class evenNumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i = i + 2) {
            System.out.println(Thread.currentThread().getName() + ":" + getPriority()+"***"+i);
        }

    }
}

class oddNumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        evenNumberThread evenNumberThread = new evenNumberThread();
        evenNumberThread.setPriority(Thread.MIN_PRIORITY);
        evenNumberThread.start();
        new oddNumberThread().start();

        new Thread(() -> {
            for (int i = 1; i <= 100; i += 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }).start();
    }
}
