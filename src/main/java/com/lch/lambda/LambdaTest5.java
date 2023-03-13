package com.lch.lambda;

import java.util.function.IntConsumer;

public class LambdaTest5 {
    public static void main(String[] args) {
        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        foreachArr(value -> System.out.println(value));
    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i :
                arr) {
            consumer.accept(i);
        }
    }
}
