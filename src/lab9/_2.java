package lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class _2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("fin.txt"));
                FileOutputStream fos = new FileOutputStream("fout.txt")) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                fos.write(String.format("%d\t%s\n", count, line).getBytes());
                count++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
