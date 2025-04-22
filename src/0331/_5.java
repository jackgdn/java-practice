import java.util.Scanner;

class Complex {
    private int a, b;

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void print() {
        System.out.println((a == 0 && b == 0) ? 0 : String.format("%d %di", this.a, this.b));
    }
}

public class _5 {
    public static void main(String[] agrs) {
        try (Scanner sc = new Scanner(System.in)) {
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b2 = sc.nextInt();
            Complex c1 = new Complex(a1 + a2, b1 + b2);
            Complex c2 = new Complex(a1 - a2, b1 - b2);
            c1.print();
            c2.print();
        }
    }
}