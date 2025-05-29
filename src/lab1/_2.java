package lab1;

import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long n = sc.nextLong();
            System.out.println(claculate(a, n));
        }
        sc.close();
    }

    public static long claculate(long a, long n) {
        long res = 0;
        long curr = 0;
        while (n-- > 0) {
            curr *= 10l;
            curr += a;
            res += curr;
        }
        return res;
    }
}