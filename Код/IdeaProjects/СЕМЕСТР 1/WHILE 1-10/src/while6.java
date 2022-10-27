import java.util.Scanner;

public class while6 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = 1;
        if(N % 2 == 0) {
            K++;
        }
        int f = 1;
        while(N >= K) {
            f *= K;
            K += 2;
        }
        System.out.println(f);
    }
}