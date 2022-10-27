import java.util.Scanner;

public class while2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int count = 0;
        while(A >= B) {
            A -= B;
            count ++;
        }
        System.out.println(count);
    }
}
