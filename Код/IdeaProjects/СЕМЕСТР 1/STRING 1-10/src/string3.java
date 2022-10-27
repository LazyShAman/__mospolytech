import java.util.Scanner;

public class string3 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        String C = cin.next();

        int CInt = C.charAt(0);
        char Cbef = (char) (CInt - 1);
        char Caft = (char) (CInt + 1);
        System.out.println(Cbef);
        System.out.println(Caft);
    }
}