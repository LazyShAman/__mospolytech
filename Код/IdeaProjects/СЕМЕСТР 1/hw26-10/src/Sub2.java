/* Примем за возрастающую подпоследовательность любую возрастающую
    последовательность с числом элементов n > 1 */

import java.util.Scanner;
import java.util.Arrays;


public class Sub2
{
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] sequence = line.split(" ");
        int[] data = Arrays.stream(sequence).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int temp = 1;
        int subseqs = 0;

        for (int i = 1; i < data.length-1; i++)
        {
            if (data[i] <= data[i-1])
            {
                if (temp > 1)
                {
                    subseqs++;
                    count += temp;
                    temp = 1;
                }
            }
            else
                temp++;
        }
        if (temp > 1)
        {
            subseqs++;
        }

        if (subseqs != 0)
        {
            double average_length = (double) (count + subseqs) / (double) subseqs;
            System.out.println(average_length);
        }
        else
            System.out.println("No subsequences!");
    }
}
