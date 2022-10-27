/* Напишите программу, вводящую натуральное число и
   печатающее количество его различных представлений в виде
   суммы двух простых чисел. */

import java.util.Scanner;

public class Exam8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int Num8 = in.nextInt();
        int pairs = Num8 / 2;
        boolean flag;
        int count = 0;

        for (int pair = 0; pair < pairs; pair++) {
            int A = 1 + pair;
            int B = Num8 - A;
            flag = true;
            for (int i = 2; i < B; i++) {
                if (A > i && A % i == 0) {
                    flag = false;
                    break;
                }

                if (B % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println(A + " " + B);
            }
        }

        System.out.println("There are " + count + " pairs");
    }
}
