package seminar1;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
class Answer4 {
    public static String[] findAndReplace(String[] strings, String target, String replacement, List<String> errors) {
        // Напишите свое решение ниже
        String[] result = Arrays.copyOf(strings, strings.length);
        boolean found = false;

        for (int i = 0; i < result.length; i++) {
            if (result[i].equals(target)) {
                result[i] = replacement;
                found = true;
            }
        }
        if (!found) {
            errors.add("Строка " + target + " не найдена");
        }
        return result;
    }
}
public class Dz4 {
    public static void main(String[] args) {
        List<String> errors = new ArrayList<>();
        String[] strings = {"apple", "banana", "cherry", "date"};
        String target = "banana";
        String replacement = "orange";
        String[] result = Answer4.findAndReplace(strings, target, replacement, errors);
        System.out.println("Результаты замены: " + Arrays.toString(result));
        if (!errors.isEmpty()) {
            System.out.println("Обнаружены ошибки:");
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
