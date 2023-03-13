package com.lch.lambda;

public class LambdaTest7 {
    interface UseString {
        String use(String str, int start, int length);
    }

    private static String subAuthorName(String str, UseString useString) {
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }

    public static void main(String[] args) {
        String subName = subAuthorName("hai", String::substring);
        System.out.println(subName);
    }

}
