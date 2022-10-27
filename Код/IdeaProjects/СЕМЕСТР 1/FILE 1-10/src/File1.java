/* Дана строка S. Если S является допустимым именем файла, то создать
   пустой файл с этим именем и вывести True. Если файл с именем S создать
   нельзя, то вывести False. */

import java.io.FileWriter;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        if (S.contains("/") || S.contains("\\") || S.contains(":") || S.contains("*") || S.contains("?")
                || S.contains("\"") || S.contains("<") || S.contains(">") || S.contains("|")) {
            System.out.println("False");
        } else {
            System.out.println("True");
            FileWriter sNamed = new FileWriter("C:/E_Drive/IdeaProjects/forfiles/" + S + ".txt");
        }
    }
}
