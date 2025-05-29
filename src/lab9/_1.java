package lab9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _1 {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("fin.txt");
                FileOutputStream fos = new FileOutputStream("fout.txt")) {
            byte[] buffer = new byte[80];
            int bytesLength = fis.read(buffer, 0, 80);
            fos.write(buffer, 0, bytesLength);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
