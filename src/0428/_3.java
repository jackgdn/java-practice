import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class _3 {

    public void count(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<String, List<Student>>();
        for (Student s : students) {
            List<Student> sList = map.getOrDefault(s.getClassName(), new ArrayList<Student>());
            sList.add(s);
            map.put(s.getClassName(), sList);
        }

        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            String className = entry.getKey();
            int totalScore = entry.getValue().stream().mapToInt(s -> (int) s.getScore()).sum();
            int studentCount = entry.getValue().size();
            double averageScore = totalScore / (double) studentCount;
            System.out.println(String.format("%s班，总分：%d，平均分：%.1f，人数：%d", className, totalScore, averageScore, studentCount));
        }
    }

    public static void main(String[] args) {
        _3 tlm = new _3();
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(scanner.next(), scanner.next(), scanner.nextInt()));
        students.add(new Student(scanner.next(), scanner.next(), scanner.nextInt()));
        students.add(new Student(scanner.next(), scanner.next(), scanner.nextInt()));
        students.add(new Student(scanner.next(), scanner.next(), scanner.nextInt()));
        students.add(new Student(scanner.next(), scanner.next(), scanner.nextInt()));
        scanner.close();
        tlm.count(students);
    }
}

class Student {
    private String name, className;
    private double score;

    public Student(String name, String className, double score) {
        this.name = name;
        this.className = className;
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public double getScore() {
        return score;
    }
}