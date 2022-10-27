import java.util.Scanner;

public class array8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = 0;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
        {
            a[i] = (int)(Math.random()*100);
            System.out.print(a[i]+" ");
        }
        System.out.println("");

        for (int i = 0; i < N; i++)
        {
            if (a[i] % 2 == 1)
            {
                System.out.print(a[i]+" ");
                K++;
            }
        }
        System.out.println("");
        System.out.println(K);
    }
}
