1. (程序题1)
编写一个程序实现如下功能，从当前目录下的文件fin.txt中读取80个字节（实际读到的字节数可能比80少）并将读来的字节写入当前目录下的文件fout.txt中。（无需验证提交，自行判断结果是否正确）

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


2. (程序题1)
使用java的输入/输出流技术将一个文本文件的内容按行读出，每读出一行就顺序添加行号，并写入到另一个文件中。（无需验证提交，自行判断结果是否正确）

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


3. (程序题1)
编写一个程序实现如下功能，把当前目录下的图片拷贝一个新的图片。（无需验证提交，自行判断结果是否正确）

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


4. (程序题1)
 遍历指定目录所有文件名称，包括子文件目录中的文件。（无需验证提交，自行判断结果是否正确）

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
