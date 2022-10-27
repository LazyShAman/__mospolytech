/* Напишите программу, вводящую последовательность целых
   чисел, которая считает их массами имеющихся в наличии
   предметов и выясняет, можно ли все эти предметы положить на
   две чашки весов так, чтобы весы находились в равновесии. */

public class Exam3 {
    public static void main (String[] args) {
        Sequence Seq3 = new Sequence();
        Sequence.toEqualize(Seq3);
        Seq3.printSequence();
    }
}