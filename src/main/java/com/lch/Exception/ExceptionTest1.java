package com.lch.Exception;

public class ExceptionTest1 {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("test1");
        } catch (NumberFormatException e) {
//            System.out.println("出现数值转换异常");

            //String getMessage()
//            System.out.println(e.getMessage());

            //printStackTrace()
            e.printStackTrace();
        } catch (Exception e){

        }
        finally {
            System.out.println("finally代码执行 ");
        }
    }
}
