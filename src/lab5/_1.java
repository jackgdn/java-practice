package lab5;

import java.util.Scanner;

abstract class Employee {
    protected String name, department;
    protected double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void showSalary() {
        System.out.println(String.format("我叫%s，在%s部门，我的工资是%.1f", name, department, salary));
    }

    abstract void showBonus();
}

final class BasicEmployee extends Employee {

    public BasicEmployee(String name, String department, double salary) {
        super(name, department, salary);
    }

    public void showBonus() {
        System.out.println("我是普通员工，没有奖金，加油升级！");
    }
}

final class GoodEmployee extends Employee {

    private double bonus;

    public GoodEmployee(String name, String department, double salary, double bonus) {
        super(name, department, salary);
        this.bonus = bonus;
    }

    public void showBonus() {
        System.out.println(String.format("我是优秀员工，我的奖金是%.1f", bonus));
    }
}

public class _1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] emp1Data = sc.nextLine().trim().split("\\s+");
        String[] emp2Data = sc.nextLine().trim().split("\\s+");
        sc.close();

        BasicEmployee emp1 = new BasicEmployee(emp1Data[0], emp1Data[1], Double.parseDouble(emp1Data[2]));
        GoodEmployee emp2 = new GoodEmployee(emp2Data[0], emp2Data[1], Double.parseDouble(emp2Data[2]),
                Double.parseDouble(emp2Data[3]));

        emp1.showSalary();
        emp1.showBonus();
        emp2.showSalary();
        emp2.showBonus();
    }
}