package seminar2;

import java.util.Arrays;

class StringSorter {
    public static String[] sortStrings(String[] strings) {
        // Введите свое решение ниже

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