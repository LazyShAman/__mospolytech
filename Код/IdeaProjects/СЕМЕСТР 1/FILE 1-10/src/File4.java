/* Даны имена четырех файлов. Найти количество файлов с указанными
   именами, которые имеются в текущем каталоге. */

import java.io.File;
import java.util.Scanner;

public class File4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;

        String[] fileNames = new String[4];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = in.next();
            File fNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + fileNames[i] + ".txt");
            if (fNamed.exists() && !fNamed.isDirectory()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
