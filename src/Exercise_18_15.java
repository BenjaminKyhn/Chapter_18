import java.util.Scanner;

public class Exercise_18_15 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("Enter a string:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Enter a char: ");
        String ch = input.next();
        System.out.println("The character " + ch + " occurs " + count(str, ch.charAt(0)) + " time(s) in " + str);
    }

    public static int count(String str, char a){
        return count(str, a, 0);
    }

    public static int count(String str, char a, int high){
        if (high < str.length()){
            int match = str.toLowerCase().charAt(high) == Character.toLowerCase(a) ? 1 : 0;
            return match + count(str, a, high + 1);
        }
        else
            return 0;
    }
}
