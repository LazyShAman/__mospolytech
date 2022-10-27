/* Напишите программу, вводящую последовательность
   наборов (x, y, z, r), которая рассматривает их в качестве
   координат центров сфер и их радиусов и определяет, вложены
   ли они друг в друга, как матрешки (не обязательно в порядке
   их ввода)." */

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Exam10 {

    public static double[] getSet(String line) {
        String[] data = line.split(" ");
        double[] set = new double[data.length];

        for (int element = 0; element < data.length; element++) {
            set[element] = Double.parseDouble(data[element]);
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter all coordinate pairs in \"x y z r\" format.\nEnter \"*\" to complete input");
        String xLine = "", yLine = "", zLine = "", rLine = "";
        int p = 1;
        while (true) {
            System.out.print(p + " sphere: ");
            String tempLine = in.nextLine();
            if (tempLine.startsWith("*"))
                break;
            double[] point = getSet(tempLine);
            xLine += point[0] + " ";
            yLine += point[1] + " ";
            zLine += point[2] + " ";
            rLine += point[3] + " ";
            p++;
        }

        double[] xSet = getSet(xLine);
        double[] ySet = getSet(yLine);
        double[] zSet = getSet(zLine);
        double[] rSet = getSet(rLine);

        boolean flag1 = false, flag2 = true;
        double t;

        while (!flag1) {
            flag1 = true;
            for (int i = 0; i < rSet.length - 1; i++) {
                if (rSet[i] > rSet[i+1]) {
                    flag1 = false;

                    t = rSet[i];
                    rSet[i] = rSet[i+1];
                    rSet[i+1] = t;

                    t = xSet[i];
                    xSet[i] = xSet[i+1];
                    xSet[i+1] = t;

                    t = ySet[i];
                    ySet[i] = ySet[i+1];
                    ySet[i+1] = t;

                    t = zSet[i];
                    zSet[i] = zSet[i+1];
                    zSet[i+1] = t;
                }
            }
        }

        for(int check = 0; check < rSet.length - 1; check++) {
            double dist = sqrt(pow(xSet[check], 2) + pow(ySet[check], 2) + pow(zSet[check], 2));
            if (rSet[check] > rSet[check+1] - dist) {
                System.out.println("No");
                flag2 = false;
                break;
            }
        }

        if (flag2)
            System.out.println("Yes");
    }
}
