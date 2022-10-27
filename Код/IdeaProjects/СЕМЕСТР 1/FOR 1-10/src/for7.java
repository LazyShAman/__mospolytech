import java.util.Scanner;

public class for7 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int summ = 0;
        for (int i = A; i <= B; i++){
            summ += i;
        }
        System.out.println(summ);
    }
}
