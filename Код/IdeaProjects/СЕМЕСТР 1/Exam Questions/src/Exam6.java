/* Напишите программу, вводящую последовательность целых
   чисел, печатающую два одинаковых ее сегмента максимальной
   длины. */

public class Exam6 {
    public static void main (String[] args) {
        Sequence Seq6 = new Sequence();
        Sequence subSeq = Seq6.twoSubSeqs();
        System.out.println("It will print -1, if there is no identical segments");
        subSeq.printSequence();
    }
}
