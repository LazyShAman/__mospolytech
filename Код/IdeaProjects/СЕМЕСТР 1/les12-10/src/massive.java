import java.util.Scanner;
import static java.lang.Math.*;

public class massive {
    public static void main(String[] args) {
        int[] a1 = {20, 10, 30};
        System.out.println(a1.length);
        System.out.println(a1[1]);

        String[] a2 = new String[3];
        System.out.println(a2[2]);

        for(int i = 0; i < a2.length; i++) {
            System.out.println(a1[i]);
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a3 = new int[n];
    }
}
