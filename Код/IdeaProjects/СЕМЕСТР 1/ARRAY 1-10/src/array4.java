import java.util.Scanner;
import static java.lang.Math.*;

public class array4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int Q = in.nextInt();
        double[] a = new double[N];
        for(int i = 0; i < N; i++) {
            a[i] = A * pow(Q, i);
            System.out.printf("%s ", a[i]);
        }
    }
}