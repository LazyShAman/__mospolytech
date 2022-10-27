import java.util.Scanner;
import static java.lang.Math.*;

public class array2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double[] a = new double[N];
        for(int i = 0; i < N; i++) {
            a[i] = pow(2, i+1);
            System.out.printf("%s ", a[i]);
        }
    }
}