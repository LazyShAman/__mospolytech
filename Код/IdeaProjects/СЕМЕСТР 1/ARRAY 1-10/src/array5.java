import java.util.Scanner;

public class array5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] F = new int[N];
        F[0] = 1;
        F[1] = 1;
        for(int i = 2; i < N; i++) {
            F[i] = F[i-1] + F[i-2];
            System.out.printf("%s ", F[i]);
        }
    }
}