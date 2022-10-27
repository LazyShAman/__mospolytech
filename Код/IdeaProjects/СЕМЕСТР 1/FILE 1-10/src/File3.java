/* Дано имя файла и вещественные числа A и D. Создать файл вещественных
   чисел с данным именем и записать в него 10 первых членов арифметической
   прогрессии с начальным членом A и разностью D: A, A + D, A + 2·D, A + 3·D, ...
 */

import java.io.FileWriter;
import java.util.Scanner;

public class File3 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        double A = in.nextDouble();
        double D = in.nextDouble();

        FileWriter sNamed = new FileWriter("C:/E_Drive/IdeaProjects/forfiles/" + S + ".txt");
        for (int i = 1; i <= 10; i++)
            sNamed.write(A + i * D + " ");
        sNamed.close();
    }
}