import java.util.Scanner;

public class Exercise_18_09 {
    public static void reverseDisplay(String value) {
        if (value.length() <= 0)
            return;
        else {
            System.out.print(value.charAt(value.length() - 1));
            String substring = value.substring(0, value.length() - 1);
            reverseDisplay(substring);
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter a string :");
        Scanner input = new Scanner(System.in);
        reverseDisplay(input.nextLine());
    }
}
