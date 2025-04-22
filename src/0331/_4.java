import java.util.Scanner;

class Student {
    private String sNO;
    private String sName;
    private int sJava;

    public Student(String sNO, String sName, int sJava) {
        this.sNO = sNO;
        this.sName = sName;
        this.sJava = sJava;
    }

    public String getSNO() {
        return this.sNO;
    }

    public void setSNO(String sNO) {
        this.sNO = sNO;
    }

    public String getSName() {
        return this.sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public int getSJava() {
        return this.sJava;
    }

    public void setSJava(int sJava) {
        this.sJava = sJava;
    }
}

public class _4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            Student[] students = new Student[n];
            while (n-- > 0) {
                String[] line = sc.nextLine().trim().split("\\s+");
                String sNO = line[0];
                String sName = line[1];
                int sJava = Integer.parseInt(line[2]);
                Student s = new Student(sNO, sName, sJava);
                students[n] = s;
            }
            System.out.println(getHigh(students));
        }
    }

    public static int getHigh(Student[] students) {
        int max_score = 0;
        for (Student s : students) {
            int sJava = s.getSJava();
            if (sJava > max_score) {
                max_score = sJava;
            }
        }
        return max_score;
    }
}
