/* Дан файл целых чисел, содержащий не менее четырех элементов. Вывести
   первый, второй, предпоследний и последний элементы данного файла. */

import java.io.File;
import java.util.Scanner;

public class File7 {
    public static void main(String[] args) throws Exception {
        File sNamed = new File("C:\\E_Drive\\IdeaProjects\\forfiles\\File6.txt");
        Scanner enter = new Scanner(sNamed);
        String line = enter.nextLine();
        int[] elements = new int[4];
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        while (enter.hasNext()) {
            String[] data = line.split(" ");
            for (String el : data) {
                if (flag1) {
                    elements[0] = Integer.parseInt(el);
                    flag1 = false;
                } else if (flag2) {
                    elements[1] = Integer.parseInt(el);
                    flag2 = false;
                } else if (flag3) {
                    elements[2] = Integer.parseInt(el);
                    flag3 = false;
                } else if (flag4) {
                    elements[3] = Integer.parseInt(el);
                    flag4 = false;
                } else {
                    elements[2] = elements[3];
                    elements[3] = Integer.parseInt(el);
                }
            }
            line = enter.nextLine();
        }
        String[] data = line.split(" ");
        for (String el : data) {
            if (flag1) {
                elements[0] = Integer.parseInt(el);
                flag1 = false;
            } else if (flag2) {
                elements[1] = Integer.parseInt(el);
                flag2 = false;
            } else if (flag3) {
                elements[2] = Integer.parseInt(el);
                flag3 = false;
            } else if (flag4) {
                elements[3] = Integer.parseInt(el);
                flag4 = false;
            } else {
                elements[2] = elements[3];
                elements[3] = Integer.parseInt(el);
            }
        }

        System.out.printf("%s %s %s %s", elements[0], elements[1], elements[2], elements[3]);
    }
}