import java.util.Scanner;

public class string5 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = "z".charAt(0); i > ("z".charAt(0) - N); i--)
        {
            System.out.println((char) i);
        }
    }
}
