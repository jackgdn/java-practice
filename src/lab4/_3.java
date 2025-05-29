package lab4;

import java.util.Scanner;

abstract class Clerk {
    protected double salary;
    protected int day;
    protected static double level;

    abstract public String toString();
}

class NormalClerk extends Clerk {
    protected static double level = 1.0;

    public NormalClerk(double salary, int day) {
        this.salary = salary;
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("普通员工的工资为：%.1f", salary * day * level);
    }
}

class Manager extends Clerk {
    protected static double level = 1.2;

    public Manager(double salary, int day) {
        this.salary = salary;
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("部门经理的工资为：%.1f", 1000.0 + salary * day * level);
    }
}

public class _3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double salary = sc.nextDouble();
            int day = sc.nextInt();
            NormalClerk normalClerk = new NormalClerk(salary, day);
            Manager manager = new Manager(salary, day);
            System.out.println(normalClerk);
            System.out.println(manager);
        }
    }
}