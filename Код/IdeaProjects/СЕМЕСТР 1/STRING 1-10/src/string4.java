import java.util.Scanner;

public class string4 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = "A".charAt(0); i < ("A".charAt(0) + N); i++)
        {
            System.out.println((char) i);
        }
    }
}