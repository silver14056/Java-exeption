package seminar2;

import java.util.Arrays;

class StringSorter {
    public static String[] sortStrings(String[] strings) {
        // Введите свое решение ниже
        if (strings == null) {
            System.out.println("strings == null");
            return new String[0];
        }
        try {
        Arrays.sort(strings);
        return strings;
        } catch (Exception e) {
            System.out.println("Exception");
            return new String[0];
        }
    }
}

public class Dz3 {
    public static void main(String[] args) {
        String[] strings;
        if (args.length > 0) {
            strings = args[0].split(",");
        } else {
            strings = new String[]{"banana", "apple", "cherry"}; // Значение по умолчанию
        }
        String[] result = StringSorter.sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }
}