import java.util.Scanner;

public class Exercise_18_25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();

        displayPermutations(s);
    }

    public static void displayPermutations(String s){
        displayPermutations("", s);
    }

    public static void displayPermutations(String s1, String s2){
        if (s2.length() == 0){
            System.out.println(s1);
        }

        for (int i = 0; i < s2.length(); i++) {
            displayPermutations(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
        }
    }
}
