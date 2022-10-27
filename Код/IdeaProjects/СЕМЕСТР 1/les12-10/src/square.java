import java.util.Scanner;

public class square
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
                if (row == 0 || row == (n-1) || column == 0 || column == (n-1))
                {
                    a[row][column] = 1;
                }
                else
                {
                    a[row][column] = 0;
                }
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}
