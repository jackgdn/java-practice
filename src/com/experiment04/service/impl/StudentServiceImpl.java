package com.experiment04.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;

public class StudentServiceImpl implements StudentService {
    List<Student> students;

    public StudentServiceImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> addStudent(Student student) {
        students.add(student);
        return students;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return students.stream()
                .filter(s -> s.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return students.stream()
                .filter(s -> s.getYear() == year && s.getSex() == sex)
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsByYearSortedById(int year) {
        return students.stream()
                .filter(s -> s.getYear() == year)
                .sorted(Comparator.comparing(Student::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<Student.Sex, List<Student>> listStudentsMapBySex() {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getSex()));
    }

    @Override
    public Map<Integer, Student> listStudentsByYearMapById(int year) {
        return students.stream()
                .filter(s -> s.getYear() == year)
                .collect(Collectors.toMap(s -> s.getId(), s -> s));
    }

    @Override
    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}
