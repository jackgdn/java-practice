package lab1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();
        while (n-- > 0) {
            int i = sc.nextInt();
            nums.add(i);
        }
        sc.close();
        nums.sort((a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            System.out.print(String.format("%d ", num));
        }
    }
}
