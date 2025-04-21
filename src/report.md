1. (程序题1)
使用接口或者抽象类编写程序实现显示员工基本信息。具体要求如下：
（1）使用接口或者抽象类实现基类Employer（体会接口和抽象类的不同），包含姓名、部门和工资三个属性，显示工资的方法showSalary（）和显示奖金的抽象方法showBonus 提示：因每位职工奖金不同，showBonus（）方法定义为抽象方法，只抽象定义，不具体实现；
（2）定义BasicEmployee和GoodEmployee类，重写Employer类中的方法，不同员工有不同的工资和奖金；
（3）定义主类进行测试，要求输入两个不同的员工信息，并输出其个人信息。
输入：
张三 前台 5000
李四 开发 6000 4000
输出：
我叫张三，在前台部门，我的工资是5000.0
我是普通员工，没有奖金，加油升级！
我叫李四，在开发部门，我的工资是6000.0
我是优秀员工，我的奖金是4000.0

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


2. (程序题1)
编写一个教师讲课的程序。所有老师都具有共同的讲课方法，但是不同科目的教师讲课内容不同，主程序中编写一个讲课的方法TeachingRace(Teacher t),显示不同的老师t讲授不同的课程内容。提示：
（1）所有老师具有共同的讲课方法，可在接口中定义一个讲课方法；
（2）不同科目的老师实现接口中的讲课方法；
（3）在主程序中定义一个讲课的方法TeachingRace(Teacher t)，构造不同的教师，显示讲课内容。
输入：wanger zhangsan
输出：
我是英语老师，I say wanger
我是数学老师，I say zhangsan

import java.util.Scanner;

interface Teacher {
    void teach(String name);
}

class EnglishTeacher implements Teacher {

    @Override
    public void teach(String name) {
        System.out.println("我是英语老师，I say " + name);
    }
}

class MathTeacher implements Teacher {

    @Override
    public void teach(String name) {
        System.out.println("我是数学老师，I say " + name);
    }
}

public class _2 {
    public static void TeachingRace(Teacher t, String name) {
        t.teach(name);
    }

    public static void main(String[] args) {
        Teacher englishTeacher = new EnglishTeacher();
        Teacher mathTeacher = new MathTeacher();

        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().trim().split("\\s+");
        sc.close();

        TeachingRace(englishTeacher, names[0]);
        TeachingRace(mathTeacher, names[1]);
    }
}


3. (程序题1)
编写一个USB接口程序，模拟计算机启动过程和关闭过程启动过程中要加载鼠标、键盘、麦克风等USB设备，具体要求如下： （1）定义一个接口USB，包含两个抽象方法turnOn()he turnOff(),分别用于表示USB设备的启动和关闭 （2）编写鼠标Mouse、键盘KeyBoard、麦克风Mic类,实现接口中的turnOn()、turnOff()方法，方法中显示“XX设备启动了”或“XX设备关闭了”即可 （3）编写计算机类Computer，要求有一个表示计算机上USB插槽数量的数组；添加USB设备的方法add（USB usb）,功能为遍历所有插槽，如果有空闲的就添加一个USB设备 模拟开机启动USB设备的powerOn（）方法，功能为遍历所有USB接口，如果连接了USB设备，则启动USB设备，然后显示“计算机开机成功” 模拟关机关闭USB设备的powerOff（）方法，功能为遍历所有USB接口，如果连接了USB设备，则关闭USB设备，然后显示“计算机关机成功” （4）编写测试类，要求建立计算机对象，建立鼠标、键盘、麦克风对象，并添加到计算机中，启动计算机，关闭计算机*/。
输出：
鼠标启动了
键盘启动了
麦克启动了
计算机开机成功
鼠标关闭了
键盘关闭了
麦克关闭了
计算机关机成功

interface USB {
    void turnOn();

    void turnOff();
}

class Mouse implements USB {
    public void turnOn() {
        System.out.println("鼠标启动了");
    }

    public void turnOff() {
        System.out.println("鼠标关闭了");
    }
}

class Keyboard implements USB {
    public void turnOn() {
        System.out.println("键盘启动了");
    }

    public void turnOff() {
        System.out.println("键盘关闭了");
    }
}

class Microphone implements USB {
    public void turnOn() {
        System.out.println("麦克启动了");
    }

    public void turnOff() {
        System.out.println("麦克关闭了");
    }
}

class Computer {
    private USB[] devices;

    public Computer() {
        devices = new USB[3];
    }

    private void add(USB device, int i) {
        devices[i] = device;
        devices[i].turnOn();
    }

    private void remove(int i) {
        devices[i].turnOff();
        devices[i] = null;
    }

    public void powerOn() {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] == null) {
                switch (i) {
                    case 0:
                        add(new Mouse(), i);
                        break;
                    case 1:
                        add(new Keyboard(), i);
                        break;
                    case 2:
                        add(new Microphone(), i);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("计算机开机成功");
    }

    public void powerOff() {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                remove(i);
            }
        }
        System.out.println("计算机关机成功");
    }
}

public class _3 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        computer.powerOff();
    }
}


4. (程序题1)
编写一个通过接口实现不同应用情况下计算平均分的程序，具体要求如下：
* 1、 编写一个ComputerAverage接口，接口有一个求平均分的抽象方法average，方法的参数为double类型的数组。
 * 2、定义Gymnastics类和School类，它们都是ComputerAverage的实现类，Gymnastics类中的平均分方法为计算体育比赛中选手的平均成绩，具体算法是去掉一个最低分，去掉一个最高分，然后对剩余的数求平均分。
 * 3、School类中的平均分为计算学生考试成绩的平均分，具体算法是分数的和除以总的科目数
 * 4、要求：在主类中声明ComputerAverage的对象，并使用为上转型对象，实现ComputerAverage的对象调用average方法， 实现多态，同样的两条语句实现两种不同计算平均分的方法。输入的成绩为一组数，数据的个数和具体的数据从键盘输入。
输入：
3
40.2
30.6
50.2
输出：
Gymnastics average is:40.20
School average is:40.33

import java.util.Scanner;

interface ComputeAverage {
    double average(double[] arr);
}

class Gymnastics implements ComputeAverage {
    @Override
    public double average(double[] arr) {
        double sum = 0, max_val = Double.MIN_VALUE, min_val = Double.MAX_VALUE;
        for (double val : arr) {
            sum += val;
            max_val = Math.max(max_val, val);
            min_val = Math.min(min_val, val);
        }
        return (sum - max_val - min_val) / (arr.length - 2);
    }
}

class School implements ComputeAverage {

    @Override
    public double average(double[] arr) {
        double sum = 0;
        for (double val : arr) {
            sum += val;
        }
        return sum / arr.length;
    }
}

public class _4 {
    public static void main(String[] ars) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double[] scores = new double[n];
            while (n-- > 0) {
                scores[n] = sc.nextDouble();
            }

            ComputeAverage gymnastics = new Gymnastics();
            System.out.println(String.format("Gymnastics average is:%.2f", gymnastics.average(scores)));

            ComputeAverage school = new School();
            System.out.println(String.format("School average is:%.2f", school.average(scores)));
        }
    }
}