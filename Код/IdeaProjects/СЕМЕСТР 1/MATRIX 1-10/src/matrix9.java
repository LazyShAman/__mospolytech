import java.util.Scanner;

public class matrix9
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
                a[row][column] = (int) (Math.random() * 100);
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        for (int row = 1; row < m; row += 2)
        {
            for (int column = 0; column < n; column++)
            {
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}
