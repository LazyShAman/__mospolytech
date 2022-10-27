import java.util.Scanner;

public class string6 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        String C = cin.next();
        String line = "";
        char Cc = C.charAt(0);

        if (Cc >= "0".charAt(0) && Cc <= "9".charAt(0))
        {
            line = "digit";
        }
        else if (Cc >= "A".charAt(0) && Cc <= "z".charAt(0))
        {
            line = "lat";
        }
        else if (Cc >= "А".charAt(0) && Cc <= "я".charAt(0))
        {
            line = "rus";
        }

        System.out.println(line);
    }
}