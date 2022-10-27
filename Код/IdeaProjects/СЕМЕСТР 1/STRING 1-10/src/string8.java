import java.util.Scanner;

public class string8 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String C = cin.next();
        int N = cin.nextInt();
        String line = "";
        for (int i = 0; i < N; i++)
        {
            line += C.charAt(0);
        }
        System.out.println(line);
    }
}