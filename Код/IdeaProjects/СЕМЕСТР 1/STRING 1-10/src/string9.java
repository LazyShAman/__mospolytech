import java.util.Scanner;
import java.lang.String;

public class string9 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String C1 = cin.next();
        String C2 = cin.next();
        int N = cin.nextInt();
        String line = "";
        for (int i = 0; i < N / 2; i++)
        {
            line += C1.charAt(0);
            line += C2.charAt(0);
        }
        System.out.println(line);
    }
}