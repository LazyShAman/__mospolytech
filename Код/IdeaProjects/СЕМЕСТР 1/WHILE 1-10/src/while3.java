import java.util.Scanner;

public class while3 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int count = 0;
        while(N >= K) {
            N -= K;
            count ++;
        }
        System.out.println(count);
        System.out.println(N);
    }
}