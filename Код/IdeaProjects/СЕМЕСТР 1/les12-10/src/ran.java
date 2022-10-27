import java.util.Scanner;

public class ran
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        double summ = 0;
        int k = 0;
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = (int)(Math.random()*100);
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]+" ");
            if(a[i] % 2 != 0)
            {
                summ += a[i];
                k++;
            }
        }
        summ /= k;
        System.out.println(summ);
    }
}
