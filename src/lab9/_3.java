package lab9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("fin.gif");
                FileOutputStream fos = new FileOutputStream("fout.gif")) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write((byte) b);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}