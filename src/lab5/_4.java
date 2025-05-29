package lab5;

import java.util.Scanner;

interface ComputeAverage {
    double average(double[] arr);
}

class Gymnastics implements ComputeAverage {
    @Override
    public double average(double[] arr) {
        double sum = 0, max_val = Double.MIN_VALUE, min_val = Double.MAX_VALUE;
        for (double val : arr) {
            sum += val;
            max_val = Math.max(max_val, val);
            min_val = Math.min(min_val, val);
        }
        return (sum - max_val - min_val) / (arr.length - 2);
    }
}

class School implements ComputeAverage {

    @Override
    public double average(double[] arr) {
        double sum = 0;
        for (double val : arr) {
            sum += val;
        }
        return sum / arr.length;
    }
}

public class _4 {
    public static void main(String[] ars) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double[] scores = new double[n];
            while (n-- > 0) {
                scores[n] = sc.nextDouble();
            }

            ComputeAverage gymnastics = new Gymnastics();
            System.out.println(String.format("Gymnastics average is:%.2f", gymnastics.average(scores)));

            ComputeAverage school = new School();
            System.out.println(String.format("School average is:%.2f", school.average(scores)));
        }
    }
}