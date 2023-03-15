package com.lch.thread;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-15  09:59
 * @Version: 1.0
 */
public class ThreadTest4 {
    public static void main(String[] args) {

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        new Thread(() -> {
            synchronized (sb1) {
                sb1.append("a");
                sb2.append("1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (sb2) {
                    sb1.append("b");
                    sb2.append("2");
                    System.out.println(sb1);
                    System.out.println(sb2);
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (sb2) {
                sb1.append("c");
                sb2.append("3");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (sb1) {
                    sb1.append("d");
                    sb2.append("4");
                    System.out.println(sb1);
                    System.out.println(sb2);
                }
            }
        }).start();
    }
}
