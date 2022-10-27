import java.util.Scanner;

public class while4 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int power = 1;
        while(N > power) {
            power *= 3;
        }
        if(N == power) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}