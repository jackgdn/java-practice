package lab1;

import java.util.Scanner;

public class _7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.MIN_VALUE;
        int max_val = Integer.MIN_VALUE, x = -1, y = -1;
        int[][] mat = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                k = sc.nextInt();
                mat[i][j] = k;
                if (k > max_val) {
                    max_val = k;
                    x = i;
                    y = j;
                }
            }
        }
        sc.close();
        System.out.println(max_val);
        System.out.println(x);
        System.out.println(y);
    }
}