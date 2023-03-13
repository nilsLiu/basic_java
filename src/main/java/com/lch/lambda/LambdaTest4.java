package com.lch.lambda;

import java.util.function.Function;

public class LambdaTest4 {
    public static void main(String[] args) {
//        Integer result = typeConver(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.valueOf(s);
//            }
//        });
        Integer result = typeConver(Integer::valueOf);
        System.out.println(result);
    }

    public static <R> R typeConver(Function<String, R> function) {
        String str = "1234";
        R result = function.apply(str);
        return result;
    }
}
