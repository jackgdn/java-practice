import java.util.Scanner;

public class _4 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        double f = sc.nextDouble();
        sc.close();

        double c = 5.0 * (f - 50.0) / 9.0 + 10.0;
        System.out.println(String.format("The temprature is %.2f.", c));
    }
}