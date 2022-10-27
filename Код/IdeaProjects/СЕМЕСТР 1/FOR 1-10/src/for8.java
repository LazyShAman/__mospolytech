import java.util.Scanner;

public class for8 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int multi = 1;
        for (int i = A; i <= B; i++){
            multi *= i;
        }
        System.out.println(multi);
    }
}

