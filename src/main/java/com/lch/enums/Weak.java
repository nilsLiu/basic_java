package com.lch.enums;

interface Info {
    void show();
}

public enum Weak implements Info {
    /**
     *
     */


    MONDAY("1") {
        @Override
        public void show() {
            System.out.println("����һ");
        }
    },
    TUESDAY("2") {
        @Override
        public void show() {
            System.out.println("���ڶ�");
        }
    };

    private final String s;

    public String getS() {
        return s;
    }

    private Weak(String s) {
        this.s = s;

    }

    public static void main(String[] args) {

        System.out.println(Weak.MONDAY.toString());

        Weak[] values = Weak.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }


//    @Override
//    public void show() {
//        System.out.println("����show�ӿ�");
//    }
}



