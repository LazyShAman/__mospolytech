/* Примем за возрастающую подпоследовательность любую возрастающую
    последовательность с ненулевым числом элементов */

import java.util.Scanner;

public class Subsequences
{
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        
        String[] data = line.split(" "); // sequence

        int subseqs = 0;
        int prev = Integer.parseInt(data[0]);
        int pres;

        for (int i = 1; i < data.length; i++)
        {
            pres = Integer.parseInt(data[i]);
            if (pres <= prev)
            {
                subseqs++;
            }
            prev = pres;
        }
        subseqs++;

        if (subseqs != 0)
        {
            double average_length = (double) (data.length) / (double) subseqs;
            System.out.println(average_length);
        }
        else
            System.out.println("No subsequences!");
    }
}
