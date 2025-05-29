package lab1;

import java.util.Scanner;

public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            res += 1 / ((double) (3 * i - 2) * Math.pow(-1.0, i + 1));
        }
        System.out.println(res);
    }
}