/* Дан файл целых чисел. Создать новый файл, содержащий те
   же элементы, что и исходный файл, но в обратном порядке. */


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class File10 {
    public static void main(String[] args) throws Exception {
        File exNamed = new File("C:/E_Drive/IdeaProjects/forfiles/File6.txt");
        Scanner enter = new Scanner(exNamed);
        String line = enter.nextLine();
        while (enter.hasNext()) {
            line += " " + enter.nextLine();
        }
        String[] data = line.split(" ");

        File geNamed = new File("C:/E_Drive/IdeaProject/forfiles/File10.txt");
        FileWriter writer = new FileWriter(geNamed);

        for (int i = data.length - 1; i > -1; i--)
            writer.write(data[i] + " ");
        writer.close();
    }
}
