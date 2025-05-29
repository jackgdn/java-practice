package lab4;

import java.util.Scanner;

class Vehicle {
    protected int wheelCount;
    protected double weight;
    protected String type;

    public Vehicle(int wheelCount, double weight, String type) {
        this.wheelCount = wheelCount;
        this.weight = weight;
        this.type = type;
    }

    public void show() {
        System.out.println(this.type);
        System.out.println(String.format("轮子数:%d个", this.wheelCount));
        System.out.println(String.format("自身重量:%.1f吨", this.weight));
    }
}

class Car extends Vehicle {
    protected int passenger;
    protected String type;

    public Car(int wheelCount, double weight, int passenger, String type) {
        super(wheelCount, weight, type);
        this.passenger = passenger;
    }

    @Override
    public void show() {
        super.show();
        System.out.println(String.format("额定乘客数:%d人", this.passenger));
    }

    public void superShow() {
        super.show();
    }
}

class Truck extends Car {
    protected double cargo;
    protected String type;

    public Truck(int wheelCount, double weight, int passenger, double cargo, String type) {
        super(wheelCount, weight, passenger, type);
        this.cargo = cargo;
    }

    @Override
    public void show() {
        super.superShow();
        System.out.println(String.format("额定乘客数%d人", this.passenger));
        System.out.println(String.format("载重量%.1f吨", this.cargo));
    }
}

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vehicleWheelCount = sc.nextInt();
        double vehicleWeight = sc.nextDouble();
        Vehicle vehicle = new Vehicle(vehicleWheelCount, vehicleWeight, "汽车:");
        vehicle.show();

        int carWheelCount = sc.nextInt();
        double carWeight = sc.nextDouble();
        int carPassenger = sc.nextInt();
        Car car = new Car(carWheelCount, carWeight, carPassenger, "小轿车:");
        car.show();

        int truckWheelCount = sc.nextInt();
        double truckWeight = sc.nextDouble();
        int truckPassenger = sc.nextInt();
        double truckCargo = sc.nextDouble();
        Truck truck = new Truck(truckWheelCount, truckWeight, truckPassenger, truckCargo, "卡车:");
        truck.show();

        sc.close();
    }
}