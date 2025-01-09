package seminar2;

import java.util.Arrays;

class Statistics {
    public static double findAverage(int[] array) {
        // Напишите свое решение ниже
        try {
        if (array == null) {
            throw new NullPointerException();
        } else if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum / array.length;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Double.NaN;
        }
    }
}

public class Dz4 {
    public static void main(String[] args) {
        int[] array;
        if (args.length > 0) {
            array = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        } else {
            array = new int[]{10, 20, 30, 40, 50}; // Значение по умолчанию
        }
        double average = Statistics.findAverage(array);
        System.out.println(average);
    }
}
