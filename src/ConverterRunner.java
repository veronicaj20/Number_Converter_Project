import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        boolean invalidBinaryDigit = false;
        boolean invalidOctalDigit = false;
        boolean invalidB10Digit = false;

        // checks if the number is valid (need to put in loop)
        if (base == 2) {
            for (int i = 0; i < digits.length && !invalidBinaryDigit; i++) {
                if (!(digits[i] == 0 || digits[i] == 1)) {
                    System.out.println("That's not a valid binary number!");
                    invalidBinaryDigit = true;
                }
            }
        }
        else if (base == 8) {
            for (int i = 0; i < digits.length && !invalidOctalDigit; i++) {
                if (!(digits[i] == 8 || digits[i] == 9)) {
                    System.out.println("That's not a valid octal number!");
                    invalidOctalDigit = true;
                }
            }
        }
        else if (base == 10) {
            for (int i = 0; i < digits.length && !invalidB10Digit; i++) {
                if (!Character.isDigit(digits[i])) {
                    System.out.println("That's not a valid base 10 number!");
                    invalidB10Digit = true;
                }
            }
        }
        else {
            System.out.println("That's not a valid base!");
        }

    }
}

