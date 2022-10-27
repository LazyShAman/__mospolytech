import java.util.Scanner;

public class while8 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = 1;

        while(N > K*K) {
            K++;
        }
        System.out.println(K-1);
    }
}