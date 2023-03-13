package com.lch.abstr.practice;

import java.util.Calendar;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        // 方式一
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入当月的月份：");
//        int month = scanner.nextInt();

        //方式二
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH + 1);

        emps[0] = new SalariedEmployee("nils", "1000", new MyDate(1999, 4, 22), 5000);
        emps[1] = new HourlyEmployee("bob", "1001", new MyDate(1965, 2, 14), 100, 150);

        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getBirthday().getMonth() == month) {
                System.out.println(emps[i].getName() + ", 本月是你的生日，恭喜你！");
                        System.out.println(emps[i] + " 月工资是：" + (emps[i].earnings() + 100));
            } else {
                System.out.println(emps[i] + " 月工资是：" + emps[i].earnings());
            }
        }


    }
}
