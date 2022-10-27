import java.util.Scanner;

public class array1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = 2*i + 1;
            System.out.printf("%s ", a[i]);
        }
    }
}