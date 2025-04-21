import java.util.Scanner;

class Worker {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Worker() {
    }

    public Worker(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void work() {
        System.out.println(String.format("%s 工作8小时", this.name));
    }

    public void work(int time) {
        System.out.println(String.format("%s 工作%d小时", this.name, time));
    }
}

public class _3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] line = sc.nextLine().trim().split("\\s+");
            int id = Integer.parseInt(line[0]);
            String name = line[1];
            int age = Integer.parseInt(line[2]);
            double salary = Double.parseDouble(line[3]);

            Worker worker = new Worker(id, name, age, salary);
            worker.work();
            int time = sc.nextInt();
            worker.work(time);
        }
    }
}