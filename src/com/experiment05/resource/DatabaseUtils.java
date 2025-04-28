package com.experiment05.resource;

import java.util.ArrayList;
import java.util.List;

import com.experiment05.entity.College;
import com.experiment05.entity.Student;
import com.experiment05.entity.Teacher;

public class DatabaseUtils {
    private static final List<Student> STUDENTS = create();

    private static List<Student> create() {
        College c1 = new College("锟斤拷息学院");
        College c2 = new College("锟斤拷锟矫癸拷锟斤拷学院");

        Teacher t1 = new Teacher(1001, "锟斤拷锟斤拷锟斤拷");
        t1.setCollege(c1);
        Teacher t2 = new Teacher(1002, "锟斤拷志锟斤拷");
        t2.setCollege(c2);

        Student s1 = new Student(201001, "锟斤拷锟斤拷锟斤拷", 2010);
        s1.setTeacher(t1);
        Student s2 = new Student(201002, "锟斤拷锟斤拷", 2010);
        s2.setTeacher(t1);
        Student s3 = new Student(201103, "锟斤拷学锟斤拷", 2011);
        s3.setTeacher(t2);
        Student s4 = new Student(201104, "锟斤拷锟斤拷", 2011);
        s4.setTeacher(t2);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        return students;
    }

    public static List<Student> getStudents() {
        return STUDENTS;
    }

}
