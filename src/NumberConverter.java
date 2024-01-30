public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(String number, int base) {
        this.base = base;
        digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (base == 16 && Character.isLetter(c)) {
                digits[i] = Character.digit(c, 16);
            } else {
                digits[i] = Character.getNumericValue(c);
            }
        }
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int decimal = 0;
        for (int i = 0; i < digits.length; i++) {
            decimal += digits[i] * Math.pow(base, digits.length - 1 - i);
        }
        String str = Integer.toString(decimal);
        int[] decArr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            decArr[i] = Character.getNumericValue(str.charAt(i));
        }
        return decArr;
    }

    public int[] convertToBinary() {
        int[] decimalDigits = convertToDecimal();

        int decimal = 0;
        for (int digit : decimalDigits) {
            decimal = decimal * 10 + digit;
        }

        int[] binaryTemp = new int[100];
        int index = 0;

        while (decimal > 0) {
            binaryTemp[index++] = decimal % 2;
            decimal /= 2;
        }

        int[] binaryArray = new int[index];
        for (int i = 0; i < index; i++) {
            binaryArray[i] = binaryTemp[index - 1 - i];
        }
        return binaryArray;
    }

    public int[] convertToOctal() {
        int[] decimalDigits = convertToDecimal();

        int decimal = 0;
        for (int digit : decimalDigits) {
            decimal = decimal * 10 + digit;
        }

        int[] octalTemp = new int[100];
        int index = 0;

        while (decimal > 0) {
            octalTemp[index++] = decimal % 8;
            decimal /= 8;
        }

        int[] octArr = new int[index];
        for (int i = 0; i < index; i++) {
            octArr[i] = octalTemp[index - 1 - i];
        }

        return octArr;
    }

    public int [] convertToHexadecimal() {
        int[] decimalDigits = convertToDecimal();

        int decimal = 0;
        for (int digit : decimalDigits) {
            decimal = decimal * 10 + digit;
        }

        int[] hexTemp = new int[100];
        int index = 0;

        while (decimal > 0) {
            hexTemp[index++] = decimal % 16;;
            decimal /= 16;
        }

        int[] hexArray = new int[index];
        for (int i = 0; i < index; i++) {
            hexArray[i] = hexTemp[index - 1 - i];
        }
        return hexArray;
    }

    public static void octalConversion(NumberConverter x) {
        int [] octalArray = x.convertToOctal();
        System.out.print("Octal number: ");
        for (int digit : octalArray) {
            System.out.print(digit);
        }
    }

    public static void decimalConversion(NumberConverter x) {
        int [] decimalDigits = x.convertToDecimal();
        System.out.print("Decimal number: ");
        for (int digit : decimalDigits) {
            System.out.print(digit);
        }
    }

    public static void binaryConversion(NumberConverter x) {
        int [] binaryDigits = x.convertToBinary();
        System.out.print("Binary number: ");
        for (int digit : binaryDigits) {
            System.out.print(digit);
        }
    }

    public static void hexConversion(NumberConverter x) {
        int [] hexDigits = x.convertToHexadecimal();
        System.out.print("Hex number: ");
        for (int digit : hexDigits) {
            if (digit < 10) {
                System.out.print(digit);
            }
            else {
                String hexLetters = "ABCDEF";
                System.out.print(hexLetters.charAt(digit - 10));
            }
        }
    }
}

