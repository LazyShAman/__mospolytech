import java.util.Scanner;

public class array3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int D = in.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = D*i + A;
            System.out.printf("%s ", a[i]);
        }
    }
}