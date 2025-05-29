package lab9;

import java.io.File;

public class _4 {
    public static void main(String[] args) {
        File path = new File(".");
        printFiles(path, 0);
    }

    public static void printFiles(File path, int indent) {
        for (File file : path.listFiles()) {
            if (file.isFile()) {
                System.out.println(String.format("%s%s", "\t".repeat(indent), file.getName()));
            } else {
                System.out.println(String.format("%s%s\\", "\t".repeat(indent), file.getName()));
                printFiles(file, indent + 1);
            }
        }
    }
}
