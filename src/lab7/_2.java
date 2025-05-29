package lab7;

import java.util.Scanner;

public class _2 {
    public static String[] arr = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int d = sc.nextInt();
            try {
                System.out.println(arr[d - 1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("输入错误");
            }
        }
    }
}
