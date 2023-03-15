package com.lch.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread
 * @Author: hai
 * @CreateTime: 2023-03-15  19:50
 * @Version: 1.0
 */

class NumThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //提交 适合使用Runnable
        executorService.submit(new NumThread());
        //执行 适合使用Callable
//        executorService.execute();

        executorService.shutdown();
    }
}
