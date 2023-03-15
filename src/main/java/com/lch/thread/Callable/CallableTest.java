package com.lch.thread.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.thread.Callable
 * @Author: hai
 * @CreateTime: 2023-03-15  14:03
 * @Version: 1.0
 */

// 1. 创建一个实现Callable的实现类
class NumThread implements Callable{

    //2. 实现call方法，将此线程需要执行的操作声明再call( ) 中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(sum);
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {

        //3. 创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4. 将此callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask<>(numThread);
        //5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Tread对象，并调用start( ) 方法。
        new Thread(futureTask).start();
        try {
            //get 方法的返回值为FutureTask构造器参数callable实现类重写的call()的返回值
            Object o = futureTask.get();
            System.out.println(Thread.currentThread().getName() + "  sum:"+ o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
