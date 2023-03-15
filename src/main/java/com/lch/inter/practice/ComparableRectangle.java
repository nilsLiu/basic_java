package com.lch.inter.practice;

public class ComparableRectangle extends Rectangle implements CompareObject{
    public ComparableRectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o){
            return 0;
        }
        if (o instanceof Rectangle){
            Rectangle c = (Rectangle) o;
            return Integer.compare(this.length * this.width, c.length * c.width);
        }else {
            throw new RuntimeException("类型不匹配");
        }
    }
}
