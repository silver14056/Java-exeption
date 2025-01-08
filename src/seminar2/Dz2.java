package seminar2;

class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        // Введите свое решение ниже
        try {
            String s = input.toLowerCase().replace(" ", "");

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}


public class Dz2 {
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "A man a plan a canal Panama"; // Значение по умолчанию
        }
        boolean result = PalindromeChecker.isPalindrome(input);
        System.out.println("Is the input a palindrome? " +
                result);
    }
}