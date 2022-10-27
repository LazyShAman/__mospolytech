import java.util.Scanner;
import java.util.function.ToDoubleFunction;

public class for10 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double summ = 0;
        for (int i = 1; i <= N; i++){
            summ += 1 / (double) (i);
            System.out.println(summ);
        }
        System.out.println(summ);
    }
}
