import java.util.Scanner;

public class square4
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[n][n];
        int m = n / 2 + n % 2;
        for (int row = 0; row < m; row++)
        {
            for (int column = row; column < m; column++)
            {
                a[row][column] = 1;
                a[row][n-column-1] = 1;
                a[n-row-1][column] = 1;
                a[n-row-1][n-column-1] = 1;
            }
        }
        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}