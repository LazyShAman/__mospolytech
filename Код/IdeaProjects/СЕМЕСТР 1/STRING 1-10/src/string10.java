import java.util.Scanner;
import java.lang.String;

public class string10 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String C = cin.next();
        String Crev = "";
        for (int i = C.length()-1; i >= 0; i--)
        {
            Crev += C.charAt(i);
        }
        System.out.println(Crev);
    }
}