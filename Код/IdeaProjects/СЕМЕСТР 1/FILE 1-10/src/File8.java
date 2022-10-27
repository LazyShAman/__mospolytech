/* Даны имена двух файлов вещественных чисел. Известно, что первый из
   них существует и является непустым, а второй в текущем каталоге отсутствует.
   Создать отсутствующий файл и записать в него начальный и конечный элементы
   существующего файла (в указанном порядке). */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class File8 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        // ищем в файле из задания №3
        System.out.print("Enter name of existing file: ");
        String exS = in.next(); // existing file
        System.out.print("Enter name of generated file: ");
        String geS = in.next(); // generated file

        // Piter
        File exNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + exS + ".txt");
        Scanner enter = new Scanner(exNamed);

        File geNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + geS + ".txt");
        FileWriter writer = new FileWriter(geNamed);

        boolean flag = true;
        String f1 = "0";

        String line = enter.nextLine();
        while (enter.hasNext()) {
            String[] data = line.split(" ");
            if (flag) {
                f1 = data[0];
                flag = false;
            }
            line = enter.nextLine();
        }
        String[] data = line.split(" ");
        if (flag) {
            f1 = data[0];
            flag = false;
        }
        writer.write(f1 + " " + data[data.length - 1]);
        writer.close();
    }
}