/* Дано имя файла и целое число N (> 1). Создать файл целых чисел с данным
   именем и записать в него N первых положительных четных чисел (2,4, ...). */

import java.io.FileWriter;
import java.util.Scanner;

public class File2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int N = in.nextInt();
        if (N > 1) {
            FileWriter sNamed = new FileWriter("C:/E_Drive/IdeaProjects/forfiles/" + S + ".txt");
            for (int i = 1; i <= N; i++)
                sNamed.write(2 * i + " ");
            sNamed.close();
        } else {
            System.out.println("N is out of the range!");
        }
    }
}
