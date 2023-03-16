package com.lch.enums;

public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }

}

//自定义枚举类
class Season {
    //1.声明属性 private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化的构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "3-5");
    public static final Season SUMMER = new Season("夏天", "6-8");
    public static final Season AUTUMN = new Season("秋天", "9-11");
    public static final Season WINTER = new Season("冬天", "12-2");
    //4.获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


}