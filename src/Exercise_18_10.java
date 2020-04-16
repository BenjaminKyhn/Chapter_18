import java.util.Scanner;

public class Exercise_18_10 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("Enter a string :");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Enter a char: ");
        String ch = input.next();
        System.out.println("The character " + ch + " occurs " + count(str, ch.charAt(0)) + " time(s) in " + str);
    }

    public static int count(String str, char a){
        if (str.length() <= 0)
            return count;
        else {
            if (str.charAt(0) == a){
                count++;
            }
            String newString = str.substring(1);
            return count(newString, a);
        }
    }
}
