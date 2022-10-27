import java.util.Scanner;

public class array6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        int A = in.nextInt();
        int B = in.nextInt();
        a[2] = A + B;
        System.out.printf("%s ", a[2]);
        for(int i = 3; i < N; i++) {
            a[i] = a[i-1] * 2;
            System.out.printf("%s ", a[i]);
        }
    }
}