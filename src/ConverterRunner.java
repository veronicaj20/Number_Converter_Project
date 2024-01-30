import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");

        Scanner s = new Scanner(System.in);
        int base = 0;
        // loop to check if the user entered a valid base
        boolean chosen = false;
        while (!chosen) {
            System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
            String choice = s.nextLine();
            int choice2 = Integer.parseInt(choice);
            if (choice2 == 2 || choice2 == 8 || choice2 == 10 || choice2 == 16) {
                base += choice2;
                System.out.println();
                chosen = true;
            }
            else {
                System.out.println("That's not a valid base!");
            }
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        s.close();

        NumberConverter nc = new NumberConverter(number, base);

        int[] digits = nc.getDigits();


        // checks whether the number entered matches with the base chosen
        boolean validDigits = true;
        for (int i = 0; i < digits.length && validDigits; i++) {
            if (base == 2) {
                if (!(digits[i] == 0 || digits[i] == 1)) {
                    System.out.println("That's not a valid binary number!");
                    validDigits = false;
                }
            }
            else if (base == 8) {
                if (!(digits[i] >= 0 && digits[i] <= 7)) {
                    System.out.println("That's not a valid octal number!");
                    validDigits = false;
                }
            }
            else if (base == 10) {
                if (!(digits[i] >= 0 && digits[i] <= 9)) {
                    System.out.println("That's not a valid base 10 number!");
                    validDigits = false;
                }
            }
            else {
                char c = number.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                    System.out.println("That's not a valid hex number!");
                }
            }
        }

        if (validDigits) {
            if (base == 2) {
                // conversion to octal
                NumberConverter.octalConversion(nc);
                System.out.println();

                // conversion to decimal
                NumberConverter.decimalConversion(nc);
                System.out.println();

                // conversion to hex
                NumberConverter.hexConversion(nc);
            }
            else if (base == 8) {
                // conversion to binary
                NumberConverter.binaryConversion(nc);
                System.out.println();

                // conversion to decimal
                NumberConverter.decimalConversion(nc);
                System.out.println();

                // conversion to hex
                NumberConverter.hexConversion(nc);
            }
            else if (base == 10) {
                // conversion to binary
                NumberConverter.binaryConversion(nc);
                System.out.println();

                // conversion to octal
                NumberConverter.octalConversion(nc);
                System.out.println();

                // conversion to hex
                NumberConverter.hexConversion(nc);
            }
            else {
                // conversion to binary
                NumberConverter.binaryConversion(nc);
                System.out.println();

                // conversion to octal
                NumberConverter.octalConversion(nc);
                System.out.println();

                // conversion to decimal
                NumberConverter.decimalConversion(nc);
                System.out.println();
            }
        }
    }

    }


