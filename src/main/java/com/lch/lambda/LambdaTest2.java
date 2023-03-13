package com.lch.lambda;

import java.util.function.IntBinaryOperator;

public class LambdaTest2 {
    public static void main(String[] args) {
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        int ans = calculateNum((left, right) -> left + right);
        System.out.println(ans);
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 1;
        int b = 2;
        return operator.applyAsInt(a, b);
    }

}
