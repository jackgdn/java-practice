package lab6;

import com.experiment04.entity.Student;
import com.experiment04.resource.DatabaseUtils;
import com.experiment04.service.impl.StudentServiceImpl;

public class _1 {
    public static void main(String[] args) {
        StudentServiceImpl srv = new StudentServiceImpl(DatabaseUtils.listStudents());
        System.out.println(srv.listStudentsByYear(2010));
        System.out.println(srv.listStudentsNames(2011, Student.Sex.MALE));
        System.out.println(srv.listStudentsByYearSortedById(2012));
        System.out.println(srv.listStudentsMapBySex());
        System.out.println(srv.listStudentsByYearMapById(2010));
        System.out.println(srv.removeStudent(201007));
    }
}