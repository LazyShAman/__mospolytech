import java.util.Scanner;

public class while1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        while(A >= B) {
            A -= B;
        }
        System.out.println(A);
    }
}
