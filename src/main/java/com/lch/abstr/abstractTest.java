package com.lch.abstr;


public class abstractTest {

    public static void main(String[] args) {
        Manager manager = new Manager("管理者", 1, 10000, 1000);
        manager.Work();

        new CommonEmployee("普通员工", 2, 5000);
    }

    /**
     * 编写-个Employee:类，声明为抽象类，
     * 包含如下三个属性：name,id,salary。
     * 提供必要的构造器和抽象方法：Work()。
     */
    public static abstract class Employee {
        private String name;
        private int id;
        private double salary;

        public Employee() {
        }

        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }


        public abstract void Work();
        // 测试
    }

    /**
     * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性
     */
    public static class Manager extends Employee {
        private double bonus;

        public Manager(String name, int id, double salary, double bonus) {
            super(name, id, salary);
            this.bonus = bonus;
        }

        public Manager(double bonus) {
            this.bonus = bonus;
        }

        @Override
        public void Work() {
            System.out.println("管理员工");
        }
    }

    /**
     * 请使用继承的思想，设计CommonEmployee类和Manager类，
     * 要求类中提供必要的方法进行属性访问。
     */
    public static class CommonEmployee extends Employee {

        public CommonEmployee() {
        }

        public CommonEmployee(String name, int id, double salary) {
            super(name, id, salary);
        }

        @Override
        public void Work() {
            System.out.println("普通员工");
        }
    }


}

