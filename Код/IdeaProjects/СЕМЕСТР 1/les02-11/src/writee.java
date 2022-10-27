import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

public class writee
{
    public static void main (String[] args) throws Exception
    {
        FileWriter newfile = new FileWriter("E:\\file.txt", true);
        newfile.write("aaa bb\n");
        newfile.write("aa bbb\n");
        newfile.close();

        FileReader fileread = new FileReader("E:\\file.txt");
        Scanner enter = new Scanner(fileread);

        int count = 0;
        while (enter.hasNextLine())
        {
            String line = enter.nextLine();
            String[] arr = line.split(" ");

            for (int i = 0; i < arr.length; i++)
            {
               if (arr[i].equals("qqq"))
               {
                   count++;
               }
            }
        }
        System.out.println(count);
        fileread.close();
    }
}
