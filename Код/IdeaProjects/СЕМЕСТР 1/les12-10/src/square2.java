import java.util.Scanner;

public class square2
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[n][n];
        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                if (row + column <= (n-1))
                {
                    a[row][column] = 1;
                }
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}
