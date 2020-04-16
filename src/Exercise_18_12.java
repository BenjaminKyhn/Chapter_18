import java.util.Scanner;

public class Exercise_18_12 {
    public static void reverseDisplay(String value, int high){
        String substring = value.substring(0, high);
        reverseDisplay(substring);
    }

    public static void reverseDisplay(String value) {
        if (value.length() <= 0)
            return;
        else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value, value.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter a string :");
        Scanner input = new Scanner(System.in);
        reverseDisplay(input.nextLine());
    }
}
