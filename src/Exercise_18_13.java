import java.util.Scanner;

public class Exercise_18_13 {
    public static void main(String[] args) {
        System.out.println("Enter 8 integers: ");
        Scanner input = new Scanner(System.in);
        int[] list = new int[8];

        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        System.out.println("The largest integer in the list is " + max(list, 0, list[0]));
    }

    private static int max(int[] list, int index, int max) {
        if (index == list.length - 1)
            return max;
        if (list[index] < list[index + 1])
            max = list[index + 1];
        return max(list, index + 1, max);
    }
}
