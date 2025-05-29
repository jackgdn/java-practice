package lab3;

public class _1 {

    public static void main(String[] args) {
        Vehicles v = new Vehicles("奥迪", "白色");
        v.showInfo();
        Car c = new Car(5, "奔驰", "黑色");
        c.showCar();
        Truck t = new Truck(20.5f, "弗兰德", "蓝色");
        t.showTruck();
    }
}

class Vehicles {
    public String brand, color;

    public Vehicles(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void run() {
        System.out.println("我已经开动了");
    }

    public void showInfo() {
        System.out.println(String.format("商标是:%s;颜色是:%s;", brand, color));
    }
}

class Car extends Vehicles {
    public int seats;

    public Car(int seats, String brand, String color) {
        super(brand, color);
        this.seats = seats;
    }

    public void showCar() {
        System.out.println(String.format("商标是:%s;颜色是:%s;座位是:%d个;", brand, color, seats));
    }
}

class Truck extends Vehicles {
    public float weight;

    public Truck(float weight, String brand, String color) {
        super(brand, color);
        this.weight = weight;
    }

    public void showTruck() {
        System.out.println(String.format("商标是:%s;颜色是:%s;载重是:%.1f吨;", brand, color, weight));
    }
}