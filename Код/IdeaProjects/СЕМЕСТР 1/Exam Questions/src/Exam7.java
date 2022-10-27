/* Напишите программу, вводящую последовательность целых
   чисел, печатающую два зеркально симметричных ее сегмента
   максимальной длины. */

public class Exam7 {
    public static void main (String[] args) {
        Sequence Seq7 = new Sequence();
        Sequence subSeq = Seq7.twoMirroredSeqs();
        System.out.println("It will print -1, if there is no identical segments");
        subSeq.printSequence();
    }
}
