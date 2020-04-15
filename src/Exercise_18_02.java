public class Exercise_18_02 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static long fib(int index){
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        long currentFib = 1;
        for (int i = 1; i <= index; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }
        return currentFib;
    }
}
