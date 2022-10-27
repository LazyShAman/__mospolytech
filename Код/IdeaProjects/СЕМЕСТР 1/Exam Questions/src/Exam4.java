/* Напишите программу, вводящую последовательность целых
   чисел, печатающую ее наиболее длинную невозрастающую
   подпоследовательность. */

public class Exam4 {
    public static void main (String[] args) {
        Sequence Seq4 = new Sequence();
        Sequence subSeq = Seq4.maxNonIncreasing();
        subSeq.printSequence();
    }
}
