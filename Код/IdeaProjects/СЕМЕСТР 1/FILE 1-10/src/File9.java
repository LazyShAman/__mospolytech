/* Даны имена двух файлов вещественных чисел. Известно, что один из них
   (не обязательно первый) существует и является непустым, а другой в текущем
   каталоге отсутствует. Создать отсутствующий файл и записать в него конечный
   и начальный элементы существующего файла (в указанном порядке). */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class File9 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        File aNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + A + ".txt");
        File bNamed = new File("C:/E_Drive/IdeaProjects/forfiles/" + B + ".txt");
        Scanner enter;
        FileWriter writer;
        if (aNamed.exists() && !aNamed.isDirectory()) {
            enter = new Scanner(aNamed);
            writer = new FileWriter(bNamed);
        } else {
            enter = new Scanner(bNamed);
            writer = new FileWriter(aNamed);
        }

        boolean flag = false;
        int f1 = 0;

        String line = enter.nextLine();
        while (enter.hasNext()) {
            String[] data = line.split(" ");
            if (!flag) {
                f1 = Integer.parseInt(data[0]);
                flag = true;
            }
            line = enter.nextLine();
        }
        String[] data = line.split(" ");

        writer.write(Integer.parseInt(data[data.length - 1]) + " " + f1);
        writer.close();
    }
}