package seminar1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Answer3 {
    public int[] subArraysWithExceptionHandling(int[] a, int[] b, List<String> errors) {
        // Введите свое решение ниже
        try {
            if (a.length != b.length) {
                throw new IllegalArgumentException("Массивы разной длины");
            }
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
            return new int[0];
        }


        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] - b[i];
        }


        try {
            for (int i : result) {
                if (i < 0) {
                    throw new RuntimeException("Отрицательный результат разности");
                }
            }
        } catch (RuntimeException e) {
            errors.add(e.getMessage());
        }
        return result;
    }
}
public class Dz3 {
    public static void main(String[] args) {
        List<String> errors = new ArrayList<>();
        int[] a = {10, 20, 30};
        int[] b = {5, 15, 35};
        int[] result = new Answer3().subArraysWithExceptionHandling(a, b, errors);
        System.out.println(Arrays.toString(result));
        //Ожидаемый результат: исключение RuntimeException


        int[] c = {10, 20};
        int[] d = {5, 15, 25};
        result = new Answer3().subArraysWithExceptionHandling(c, d, errors);
        System.out.println(Arrays.toString(result));
        //Ожидаемый результат: исключение IllegalArgumentException


        // Проверяем, если были ошибки
        if (!errors.isEmpty()) {
            System.out.println("Обнаружены ошибки:");
            for (String error : errors) {
                System.out.println(error);
            }
        } else {
            System.out.println("Ошибок не обнаружено.");
        }
    }
}

