package lab6;

import java.util.List;
import java.util.Optional;

import com.experiment05.entity.College;
import com.experiment05.entity.Student;
import com.experiment05.entity.Teacher;
import com.experiment05.resource.DatabaseUtils;

public class _2 {
    public static void main(String[] args) {
        System.out.println(getCollegeName(DatabaseUtils.getStudents().get(0)));
        System.out.println(isTeacher(DatabaseUtils.getStudents().get(0), "曾志优"));
        System.out.println(getCollegeName(DatabaseUtils.getStudents(), 8888));
        printCollegeName(DatabaseUtils.getStudents(), 201001, 1002);
    }

    /**
     * 基于给定学生，获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * 
     * @param student
     * @return
     */
    private static String getCollegeName(Student student) {
        return Optional.ofNullable(student)
                .map(s -> s.getTeacher())
                .map(t -> t.getCollege())
                .map(c -> c.getName())
                .orElse("未知学院");
    }

    /**
     * 基于给定学生及教师姓名，判断是否为给定学生的指导教师。
     * 不匹配或不存在，均返回false
     * 
     * @param student
     * @param teacherName
     * @return
     */
    private static boolean isTeacher(Student student, String teacherName) {
        return Optional.ofNullable(student)
                .map(s -> s.getTeacher())
                .map(t -> t.getName())
                .orElse("")
                .equals(teacherName);
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber
     * @return
     */
    private static String getCollegeName(List<Student> students, int sNumber) {
        return students.stream()
                .filter(s -> s.getNumber() == sNumber)
                .findFirst()
                .map(s -> s.getTeacher())
                .map(t -> t.getCollege())
                .map(c -> c.getName())
                .orElse("未知学院");
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber，学生编号
     * @param tNumber，教师编号
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
        System.out.println(students.stream()
                .filter(s -> s.getNumber() == sNumber)
                .findFirst()
                .map(s -> s.getTeacher())
                .map(t -> t.getCollege())
                .map(c -> c.getName())
                .orElse("未知学院"));
    }

}