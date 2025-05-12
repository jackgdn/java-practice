import java.util.Scanner;

public class _1 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt(), b = sc.nextInt();
            try {
                System.out.println(String.format("第一个数/第二个数=%d", a / b));
            } catch (ArithmeticException ae) {
                System.out.println("第二个数不能为0");
            }
        }
    }
}
