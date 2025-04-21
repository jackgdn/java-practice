import java.util.Scanner;

abstract class Dog {
    protected String breed, color;
    protected int weight;

    public Dog(String bread, int weight, String color) {
        this.breed = bread;
        this.weight = weight;
        this.color = color;
    }

    abstract void show();
}

class UnspottedDog extends Dog {
    public UnspottedDog(String breed, int weight, String color) {
        super(breed, weight, color);
    }

    @Override
    public void show() {
        System.out.println(String.format("这是一只%s犬", breed));
    }
}

class SpottedDog extends Dog {
    private String spotColor;

    public SpottedDog(String breed, int weight, String color, String spotColor) {
        super(breed, weight, color);
        this.spotColor = spotColor;
    }

    @Override
    public void show() {
        System.out.println(String.format("这是一只%s体重为%d,颜色为%s", breed, weight, color));
        System.out.println(String.format("这是一只%s,颜色为%s,斑点颜色为%s", breed, color, spotColor));
    }
}

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] spottedDogData = sc.nextLine().trim().split("\\s+");
        String[] unspottedDogData = sc.nextLine().trim().split("\\s+");
        sc.close();

        Dog spottedDog = new SpottedDog(
                spottedDogData[0],
                Integer.parseInt(spottedDogData[1]),
                spottedDogData[2],
                spottedDogData[3]);
        Dog unspottedDog = new UnspottedDog(
                unspottedDogData[0],
                Integer.parseInt(unspottedDogData[1]),
                unspottedDogData[2]);

        spottedDog.show();
        unspottedDog.show();
    }
}