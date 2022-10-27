import java.util.Scanner;

public class ran2
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[n][n];
        int count = 0;
        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                a[row][column] = (int) (Math.random() * 100);
                System.out.printf("%s ", a[row][column]);
                if (a[row][column] % 2 == 1 && a[row][column] % 5 == 0)
                {
                    count++;
                }
            }
            System.out.println("");
        }
        System.out.println(count);
    }
}
