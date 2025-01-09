package attestation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startMessage = """
                Введите данные через пробел в следующем формате:
                Фамилия Имя Отчество датарождения номертелефона пол(m/f)
                Образец: Иванов Иван Иванович 15.06.2011 79181234567 m""";
        String surname;
        String name;
        String patronymic;
        LocalDate dateOfBirth;
        long phoneNumber;
        String gender;

        System.out.println(startMessage);
        String str = sc.nextLine();
        sc.close();


        try {
            String[] arr = str.split(" ");

            if (arr.length != 6) {
                System.out.println("Неверный формат данных");
                throw new IllegalArgumentException();
            }
            surname = arr[0];
            name = arr[1];
            patronymic = arr[2];
            dateOfBirth = parseDate(arr[3]);
            phoneNumber = parsePhone(arr[4]);
            gender = parseGender(arr[5]);

            writeToFile(surname, name, patronymic, dateOfBirth, phoneNumber, gender);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка:" + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate parseDate(String noValidDate) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate validDate;
        validDate = LocalDate.parse(noValidDate, formatter);
        return validDate;
    }

    private static long parsePhone(String noValidPhone) {
        long validPhone;
        try {
            validPhone = Long.parseLong(noValidPhone);
            return validPhone;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
    }

    private static String parseGender(String noValidGender) {
        String validGender = noValidGender.toLowerCase();
        if (validGender.equals("m") || validGender.equals("f")) {
            return validGender;
        } else {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }

    private static void writeToFile(String surname, String name, String patronymic, LocalDate dateOfBirth, long phoneNumber, String gender) throws IOException {
        String path = surname + ".txt";
        String result = String.format("<%s><%s><%s><%s><%s><%s>", surname, name, patronymic, dateOfBirth, phoneNumber, gender);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(result);
            writer.newLine();
        }
    }
}
