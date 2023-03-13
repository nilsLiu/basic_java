package com.lch.lambda;

import java.util.function.IntBinaryOperator;

public class Lambda_test {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("run方法被执行");
            }
        }).start();

        new Thread(() -> System.out.println("亚拉索")).start();
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 1;
        int b = 2;
        return operator.applyAsInt(a, b);
    }

}

