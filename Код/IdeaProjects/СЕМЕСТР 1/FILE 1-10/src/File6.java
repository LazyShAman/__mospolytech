/* Дано целое число K и файл, содержащий неотрицательные целые числа.
   Вывести K-й элемент файла (элементы нумеруются от 1).
   Если такой элемент отсутствует, то вывести –1. */

import java.io.File;
import java.util.Scanner;

public class File6 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        File sNamed = new File("C:/E_Drive/IdeaProjects/forfiles/File6.txt");
        Scanner enter = new Scanner(sNamed);

        int result = -1;
        int amount = 0;
        String line = enter.nextLine();
        while (enter.hasNext()) {
            String[] data = line.split(" ");
            if (data.length + amount >= K && K > 0) {
                result = Integer.parseInt(data[K - amount - 1]);
                break;
            }
            amount += data.length;
            line = enter.nextLine();
        }
        String[] data = line.split(" ");
        if (result == -1 && data.length + amount >= K && K > 0)
            result = Integer.parseInt(data[K - amount - 1]);

        System.out.print(result);
    }
}
