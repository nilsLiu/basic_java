package com.lch.abstr.practice;

public class SalariedEmployee extends Employee {

    private int monthlySalary;

    public SalariedEmployee(String name, String number, MyDate birthday) {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, String number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee:" + super.toString();
    }
}
