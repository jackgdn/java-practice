package lab5;

import java.util.Scanner;

interface Teacher {
    void teach(String name);
}

class EnglishTeacher implements Teacher {

    @Override
    public void teach(String name) {
        System.out.println("我是英语老师，I say " + name);
    }
}

class MathTeacher implements Teacher {

    @Override
    public void teach(String name) {
        System.out.println("我是数学老师，I say " + name);
    }
}

public class _2 {
    public static void TeachingRace(Teacher t, String name) {
        t.teach(name);
    }

    public static void main(String[] args) {
        Teacher englishTeacher = new EnglishTeacher();
        Teacher mathTeacher = new MathTeacher();

        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().trim().split("\\s+");
        sc.close();

        TeachingRace(englishTeacher, names[0]);
        TeachingRace(mathTeacher, names[1]);
    }
}
