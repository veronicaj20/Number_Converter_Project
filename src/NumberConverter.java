public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
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
        int [] decArr = new int[str.length()];
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
}

