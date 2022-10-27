import java.util.Scanner;

public class for2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        for (int i = A; i <= B; i++){
            System.out.println(i);
        }
        System.out.println(B - A + 1);
    }
}
