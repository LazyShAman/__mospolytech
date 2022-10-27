import java.util.Scanner;

public class while5 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = 0;
        while(N > 1) {
            N /= 2;
            K++;
        }
        System.out.println(K);
    }
}