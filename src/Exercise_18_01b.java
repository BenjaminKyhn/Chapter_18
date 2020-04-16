import java.math.BigInteger;
import java.util.Scanner;

public class Exercise_18_01b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = input.nextInt();
        BigInteger bigN = BigInteger.valueOf(n);

        System.out.println("Factorial of " + n + " is " + factorial(bigN));
    }

    // Return the factorial for the specified number
    public static BigInteger factorial(BigInteger n){
        if (n.equals(BigInteger.ZERO)) // Base case
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE))); // Recursive call
    }
}
