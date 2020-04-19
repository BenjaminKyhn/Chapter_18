import java.util.Scanner;

public class Exercise_18_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int value = input.nextInt();

        System.out.println(dec2Bin(value));
    }

    public static String dec2Bin(int value){
        boolean startingValueIsZero = (value == 0);
        return dec2Bin(value, "", startingValueIsZero);
    }

    public static String dec2Bin(int value, String binString, boolean startingValueIsZero){
        if (startingValueIsZero){
            return "0";
        }
        else{
            if (value == 0){
                return binString;
            }
            else {
                binString = (value % 2 == 0 ? "0" : "1") + binString;
                return dec2Bin(value / 2, binString, startingValueIsZero);
            }
        }
    }
}
