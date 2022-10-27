/* Особенность задачи в том, что на месте последней графы сведений
    должен стоять пробел для корректного считывания строки */

import java.io.FileReader;
import java.util.Scanner;

public class List2 {
    public static void main(String[] args) throws Exception {
        FileReader fileread = new FileReader("E:\\grouplist.txt");
        Scanner enter = new Scanner(fileread);

        while (enter.hasNextLine()) {
            String line = enter.nextLine();
            String[] arr = line.split(":");
            arr[0] = arr[0].replaceAll(" ", "");
            arr[1] = arr[1].replaceAll(" ", "");
            arr[2] = arr[2].replaceAll(" ", "");

            if (arr[0].equals("") || arr[1].equals("") || arr[2].equals("")) {
                System.out.println(line);
            }
        }
        fileread.close();
    }
}
