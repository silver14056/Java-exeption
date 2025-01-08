package seminar1;

class Answer1 {
    public static int convertAndSum(String[] strings) {
        // Введите свое решение ниже
        int sum = 0;
        for(String s : strings) {
            try {
            int i = Integer.parseInt(s);
            sum += i;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Ошибка преобразования строки в число: " + s);
            }
        }
        if (sum > 100) {
            throw new ArithmeticException("Превышен лимит суммы");
        }
        return sum;
    }
}
public class Dz1 {
    public static void main(String[] args) {
        // Первая попытка: корректный ввод
        try {
            String[] strings = {"10", "20", "70"};
            System.out.println(Answer1.convertAndSum(strings));
            // Ожидаемый результат: 100
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Вторая попытка: ввод с некорректным числом
        try {
            String[] invalidStrings = {"10", "20", "abc"};
            System.out.println(Answer1.convertAndSum(invalidStrings));
            //Ожидаемый результат: исключение NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Третья попытка: сумма превышает лимит
        try {
            String[] overLimitStrings = {"50", "60"};
            System.out.println(Answer1.convertAndSum(overLimitStrings));
            // Ожидаемый результат: исключение ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
