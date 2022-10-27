import java.util.Scanner;

public class string7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String C = cin.next();
        int N = C.length() - 1;
        System.out.println((int) C.charAt(0));
        System.out.println((int) C.charAt(N));
    }
}
