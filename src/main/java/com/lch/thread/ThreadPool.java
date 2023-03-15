package com.lch.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
        //提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) executorService;
//        service1.setCorePoolSize(15);

        // 适合使用Runnable的操作
        executorService.submit(new NumThread());
        // 适合使用Callable
//        executorService.execute();
        //关闭连接池
        executorService.shutdown();
    }
}
