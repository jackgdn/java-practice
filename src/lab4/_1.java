package lab4;

import java.text.DecimalFormat;
import java.util.Scanner;

abstract class Vehicle {
    protected double weight, distance;

    public Vehicle(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public Vehicle() {
        this(0.0, 0.0);
    }

    abstract public double calculateFee();

    abstract public String toString();
}

class Truck extends Vehicle {

    public Truck(double weight, double distance) {
        super(weight, distance);
    }

    public Truck() {
        super();
    }

    @Override
    public double calculateFee() {
        if (distance > 1000 || weight > 60) {
            return -1;
        } else {
            return weight * distance * 120;
        }
    }

    @Override
    public String toString() {
        double fee = calculateFee();
        return (fee == -1) ? "卡车:\n拒载"
                : String.format("卡车:\n货物的重量是：%.1f\n货物的运送的距离是：%.1f\n运费为：%.1f", weight, distance, fee);
    }
}

class Train extends Vehicle {
    public Train(double weight, double distance) {
        super(weight, distance);
    }

    public Train() {
        super();
    }

    @Override
    public double calculateFee() {
        if (distance <= 900) {
            return weight * distance * 250;
        } else {
            return weight * distance * 300;
        }
    }

    @Override
    public String toString() {
        double fee = calculateFee();
        return String.format("火车:\n货物的重量是：%.1f\n货物的运送的距离是：%.1f\n运费为：%s", weight, distance,
                (fee >= 1E+8) ? (new DecimalFormat("0.##E0")).format(fee) : String.format("%.1f", fee));
    }
}

public class _1 {
    public static void main(String[] args) {
        double weight, distance;
        try (Scanner sc = new Scanner(System.in)) {
            weight = sc.nextDouble();
            distance = sc.nextDouble();
        }

        Truck truck = new Truck(weight, distance);
        Train train = new Train(weight, distance);
        System.out.println(truck);
        System.out.println(train);
    }
}