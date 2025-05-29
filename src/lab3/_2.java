package lab3;

public class _2 {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.6, 2.0);
        Cuboid cuboid = new Cuboid(2, 5, 4.2);
        System.out.println("矩形的面积:" + rectangle.getArea());
        System.out.println("长方形的体积:" + cuboid.getVolume());
    }
}

class Rectangle {
    public double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

class Cuboid extends Rectangle {
    public double height;

    public Cuboid(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }
}