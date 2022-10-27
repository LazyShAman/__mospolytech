import java.util.Scanner;

public class matrix5
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        int d = cin.nextInt();
        int[][] a = new int[m][n];
        int[] b = new int[m];
        for (int i = 0; i < m; i++)
        {
            b[i] = (int)(Math.random()*100);
            System.out.printf("%s ", b[i]);
        }
        System.out.println("");
        System.out.println("");
        for (int row = 0; row < m; row++)
        {
            for (int column = 0; column < n; column++)
            {
                a[row][column] = b[row] + d * column;
                System.out.printf("%s ", a[row][column]);
            }
            System.out.println("");
        }
    }
}
