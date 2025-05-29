package lab1;

import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int yearA = sc.nextInt();
        int yearB = sc.nextInt();
        sc.close();

        int count = 0;
        for (int year = yearA; year <= yearB; year++) {
            if (isLeapYear(year)) {
                System.out.print(String.format("%d ", year));
                count++;
            }
            if (count == 4) {
                System.out.println();
                count = 0;
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}