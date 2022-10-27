import java.util.Scanner;

public class while10 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = 0;
        int R = 1;
        while(N > R) {
            R *= 3;
            K++;
        }
        System.out.println(K-1);
    }
}