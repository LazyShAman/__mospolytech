/* Напишите программу, вводящую последовательность пар
   действительных чисел, которая считает их координатами точек
   на плоскости и находит среди них такую, что сумма расстояний
   от нее до всех остальных точек минимальна. */

import java.util.Scanner;

public class Exam9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter all coordinate pairs in \"x y\" format.\nEnter \"*\" to complete input");
        String xLine = "", yLine = "";
        int p = 1;
        while (true) {
            System.out.print(p + " pair: ");
            String tempLine = in.nextLine();
            if (tempLine.startsWith("*"))
                break;
            Sequence tempSec = new Sequence(tempLine);
            xLine += tempSec.getElement(0) + " ";
            yLine += tempSec.getElement(1) + " ";
            p++;
        }

        Sequence xSeq = new Sequence(xLine);
        Sequence ySeq = new Sequence(yLine);

        Sequence thePoint = Sequence.closestPoint(xSeq, ySeq);
        thePoint.printSequence();
    }
}
