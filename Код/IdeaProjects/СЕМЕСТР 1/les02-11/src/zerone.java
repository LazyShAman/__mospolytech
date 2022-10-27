import java.util.Scanner;

public class zerone
{
    public static void main (String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int previous = 0;
        int current = 0;
        int count = 0;
        while (current == 0 || current == 1)
        {
            current = cin.nextInt();
            if (current != 0 && current != 1)
            {
                break;
            }
            if (previous == 0 && current == 1)
            {
                count++;
                previous = current;
            }
            else
            {
                previous = current;
            }
            System.out.println(count);
        }
        System.out.println(count);
    }
}
