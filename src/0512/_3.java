import java.util.Scanner;

public class _3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String user = scanner.next();
            String pass = scanner.next();
            scanner.close();
            login(user, pass);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void login(String user, String pass) throws LoginException {
        if (user.equals("admin") && pass.equals("admin")) {
            System.out.println("欢迎admin");
        } else if (!user.equals("admin")) {
            throw new LoginException(String.format("用户名%s不存在", user));
        } else if (!pass.equals("admin")) {
            throw new LoginException(String.format("密码错误"));
        }
    }
}

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}
