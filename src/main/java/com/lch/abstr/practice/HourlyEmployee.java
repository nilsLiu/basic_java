package com.lch.abstr.practice;

public class HourlyEmployee extends Employee {

    private int wage;
    private int hour;


    public HourlyEmployee(String name, String number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee(String name, String number, MyDate birthday) {
        super(name, number, birthday);
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee" + super.toString();
    }
}
