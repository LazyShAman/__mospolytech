import java.util.Scanner;

public class mediumvalue
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String line = in.next();
        String subs = "";
        int sum = 0;
        for (int i = 0; i < line.length(); i++)
        {
            if ((int)(line.charAt(i)) >= 0 && (int)(line.charAt(i)) <= 9)
            {
                subs += line.charAt(i);
            }
            else if (line.charAt(i) == ",")
            {
                sum += (int)(subs);
            }

        }
    }
}
