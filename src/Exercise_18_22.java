import java.util.Scanner;

public class Exercise_18_22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int value = input.nextInt();

        System.out.println(dec2Hex(value));
    }

    public static String dec2Hex(int value) {
        boolean startingValueIsZero = (value == 0);
        return dec2Hex(value, "", startingValueIsZero);
    }

    public static String dec2Hex(int value, String hexString, boolean startingValueIsZero) {
        if (startingValueIsZero) {
            return "0";
        } else {
            if (value == 0) {
                return hexString;
            }
            hexString = getHexDigit(value % 16) + hexString;
            return dec2Hex(value / 16, hexString, startingValueIsZero);
        }
    }

    private static char getHexDigit(int value) {
        if (value >= 0 && value <= 9) {
            return String.valueOf(value).charAt(0);
        }
        char ch = 0;
        switch (value) {
            case 10:
                ch = 'A';
                break;
            case 11:
                ch = 'B';
                break;
            case 12:
                ch = 'C';
                break;
            case 13:
                ch = 'D';
                break;
            case 14:
                ch = 'E';
                break;
            case 15:
                ch = 'F';
        }
        return ch;
    }
}
