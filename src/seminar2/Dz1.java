package seminar2;

class DateValidator {

    public static String validateDate(String date) {
        // Введите свое решение ниже
        String[] arr;
        int year = 0;
        int month = 0;
        int day = 0;

        int[] monthValue = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (date.length() != 10) {
            return "Неверный формат даты(Неверное колличество символов в строке)";
        }

        arr = date.split("-");
        if (arr.length != 3) {
            return "Неверный формат даты(Неверное колличество элементов в строке или не верный делитель)";
        }

        try {
        year = Integer.parseInt(arr[0]);
        month = Integer.parseInt(arr[1]);
        day = Integer.parseInt(arr[2]);
        } catch (NumberFormatException e) {
            return "Неверный формат даты(Не парсится)";
        }

        if (year < 1 || year > 9999) {
            return "Неверный формат даты(Неверное значение года)";
        }

        if (month < 1 || month > 12) {
            return "Неверный формат даты((Неверное значение месяца)";
        }

        if (isLeapYear(year)) {
            monthValue[1] = 29;
        }

        if (day < 1 || day > monthValue[month - 1]) {
            return "Неверный формат даты(Неверное значение дня)";
        }

        return "Формат даты верный";
    }


    // Метод для проверки високосного года
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

public class Dz1 {
    public static void main(String[] args) {
        String date;
        if (args.length > 0) {
            date = args[0];
        } else {
            date = "2024-02-29"; // Значение по умолчанию
        }
        String result = DateValidator.validateDate(date);
        System.out.println(result);
    }
}
