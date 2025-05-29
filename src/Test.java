import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        String p1 = "C:/";
        String p2 = "a";
        String p3 = "b";

        System.out.println(p1 + p2 + p3);
        System.out.println(Paths.get(p1 + p2 + p3));
        System.out.println(Paths.get(p1).resolve(p2).resolve(p3));
        System.out.println(Paths.get(p3).resolve(p2).resolve(p1));
    }
}
