import java.util.Scanner;

public class quickpow
{
    public static void main (String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(); // число
        int b = cin.nextInt(); // степень
        int result = 1;
        while (b > 0)
        {
            //if (b % 2 == 1)
            if ((b&1) == 1)
            {
                result *= a;
            }
            a *= a;
            //b /= 2;
            //b = b>>1;
            b >>= 1;
        }
        System.out.println(result);
    }
}
