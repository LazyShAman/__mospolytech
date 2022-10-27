import java.util.Scanner;
import static java.lang.Math.*;

public class for9 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int sump = 0;
        for (int i = A; i <= B; i++){
            sump += pow(i, 2);
        }
        System.out.println(sump);
    }
}
