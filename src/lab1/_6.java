package lab1;

import java.util.Scanner;

public class _6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int plain = sc.nextInt();
        sc.close();
        int a = plain / 1000;
        int b = (plain / 100) % 10;
        int c = (plain / 10) % 10;
        int d = plain % 10;

        a = (a + 9) % 10;
        b = (b + 9) % 10;
        c = (c + 9) % 10;
        d = (d + 9) % 10;

        System.out.println(String.format("The encrypted number is %d%d%d%d", c, d, a, b));
    }
}