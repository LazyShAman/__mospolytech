/* Дано имя файла целых чисел. Найти количество элементов, содержащихся
   в данном файле. Если файла с таким именем не существует, то вывести –1. */

import java.io.File;
import java.util.Scanner;

public class File5 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String S = in.next();
        // ищем в файле из задачи №2
        File sNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + S + ".txt");
        if (sNamed.exists() && !sNamed.isDirectory()) {
            Scanner enter = new Scanner(sNamed);

            int amount = 0;
            String line = enter.nextLine();
            while (enter.hasNext()) {
                String[] data = line.split(" ");
                amount += data.length;
                line = enter.nextLine();
            }
            String[] data = line.split(" ");
            amount += data.length;

            System.out.println(amount);
        } else
            System.out.println("-1");
    }
}
