package com.lch.Exception;

public class EcmDef {
    public static void main(String[] args) {


        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            int result = ecm(i,j);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (EcDef e) {
            e.printStackTrace();
        }
    }

    private static int ecm(int a, int b) throws EcDef{
        if (a < 0 | b < 0) {
            throw new EcDef("分子或分母为复数");
        } else return a / b;
    }
}

class EcDef extends RuntimeException {
    static final long serialVersionUID = -70345766939L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }

    public EcDef(String message, Throwable cause) {
        super(message, cause);
    }

    public EcDef(Throwable cause) {
        super(cause);
    }

    public EcDef(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
