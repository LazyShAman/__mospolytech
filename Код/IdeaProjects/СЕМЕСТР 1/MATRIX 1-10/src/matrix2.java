import java.util.Scanner;

public class matrix2
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        int[][] a = new int[m][n];
        for (int row = 0; row < m; row++)
        {
            for (int column = 0; column < n; column++)
            {
                a[row][column] = 10 * (1+ column);
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}