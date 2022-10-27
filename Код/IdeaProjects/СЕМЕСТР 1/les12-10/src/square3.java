import java.util.Scanner;

public class square3
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[n][n];
        for (int row = 0; row < n; row++)
        {
            for (int column = row; column < n; column++)
            {
                a[row][column] = 1;
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