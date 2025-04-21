import java.util.Scanner;

class Dog {
    public String name;
    public int age;
    public String kind;
    public String host;
    public double price;

    public void run() {
        System.out.println("小狗Dog跑的老快了");
    }

    public void eat(int n) {
        System.out.println(String.format("小狗今晚要吃%d根肉骨头", n));
    }

    public void sleep(double num) {
        System.out.println(String.format("小狗睡了%.1f个小时", num));
    }

    public void play(String host) {
        System.out.println(String.format("小狗与%s玩的很开心", host));
    }

    public void bark() {
        System.out.println("小狗喜欢汪汪叫");
    }

    public void show() {
        System.out.println(
                String.format("名字:%s,年龄:%d,品种:%s,主人:%s,价格:%.2f", this.name, this.age, this.kind, this.host,
                        this.price));
    }
}

public class _1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            String kind = line[2];
            String host = line[3];
            double price = Double.parseDouble(line[4]);

            Dog dog = new Dog();
            dog.name = name;
            dog.age = age;
            dog.kind = kind;
            dog.host = host;
            dog.price = price;

            dog.show();
            dog.run();
            int n = sc.nextInt();
            dog.eat(n);
            double num = sc.nextDouble();
            dog.sleep(num);
            sc.nextLine();
            host = sc.nextLine();
            dog.play(host);
            dog.bark();
        }
    }
}