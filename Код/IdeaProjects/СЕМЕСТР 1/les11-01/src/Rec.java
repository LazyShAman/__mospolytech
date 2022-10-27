import java.util.Scanner;

public class Rec {
    public static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int multiply(int term, int times) {
        if (term >= 0 && times < 0)
            return multiply(times, term);
        if (times == 0)
            return 0;
        else return term + multiply(term, times - 1);
    }

    public static double quickPow(double num, int power) {
        if (power < 0) return quickPow(1 / num, -power);
        if (power != 0) {
            if ((power & 1) == 1)
                return num * quickPow(num * num, power >> 1);
            else return quickPow(num * num, power >> 1);
        } else return 1;
    }

    public static int GCDs(int A, int B) {
        if (B == 0)
            return Math.abs(A);
        else
            return GCDs(Math.abs(B), Math.abs(A % B));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(factorial(n));
        System.out.println(fibonacci(n));
        System.out.println(multiply(a, b));
        System.out.println(quickPow(a, b));
        System.out.println(GCDs(a, b));
    }
}
