package com.lch.Exception;

public class ExceptionTest2 {

    public static void main(String[] args) throws NumberFormatException {
        try {
            test();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws NumberFormatException {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }
}
