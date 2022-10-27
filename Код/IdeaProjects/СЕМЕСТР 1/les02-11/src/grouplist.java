import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class grouplist
{
    public static void main (String[] args) throws Exception
    {
        FileReader fileread = new FileReader("E:\\grouplist.txt");
        Scanner enter = new Scanner(fileread);

        int search = 2002;
        while (enter.hasNextLine())
        {
            String line = enter.nextLine();
            String[] arr = line.split(":");
            arr[1] = arr[1].replaceAll(" ", "");
            if (arr[1].equals(""))
            {
                arr[1] += search;
            }
            if (Integer.parseInt(arr[1]) < search)
            {
                System.out.println(line);
            }
        }
        fileread.close();
    }
}
