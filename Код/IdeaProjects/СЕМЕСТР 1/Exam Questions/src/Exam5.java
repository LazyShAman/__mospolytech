/* Напишите программу, вводящую последовательность целых
   чисел, печатающую монотонный сегмент максимальной длины. */

public class Exam5 {
    public static void main (String[] args) {
        Sequence Seq5 = new Sequence();
        Sequence subSeq = Seq5.maxMonotone();
        subSeq.printSequence();
    }
}