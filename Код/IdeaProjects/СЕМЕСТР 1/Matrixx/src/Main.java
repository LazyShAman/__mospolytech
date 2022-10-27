import java.util.Scanner;

// we will name independent matrices with capital letters of the alphabet
// and resulting matrices with p for Plus, m for Minus, b for MultiplyBy and t for Times with index
public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        // let it be 2x2
        Matrix A = new Matrix();
        A.fillRandomMatrix();
        System.out.println("\nMatrix A");
        A.printMatrix();

        A.Plus(A).Plus(A).printMatrix();
        /*
        Matrix t1 = A.Times(5);
        System.out.println("\nMatrix A x 5");
        t1.printMatrix();
        System.out.println("\nEnter the multiplier:");
        int x = in.nextInt();
        Matrix t2 = A.Times(x);
        System.out.printf("\nMatrix A x %s\n", x);
        t2.printMatrix();

        // 2x2
        Matrix B = new Matrix(2, 2);
        B.fillMatrix();
        System.out.println("\nMatrix B");
        B.printMatrix();

        Matrix p1 = A.Plus(B);
        System.out.println("\nMatrix A + B");
        p1.printMatrix();

        Matrix m1 = B.Minus(A);
        System.out.println("\nMatrix B - A");
        m1.printMatrix();

        System.out.println("\nEnter the size of matrix:");
        int m = in.nextInt();
        int n = in.nextInt();
        // let it be 2x3
        Matrix C = new Matrix(m, n);
        C.fillRandomMatrix();
        System.out.println("\nMatrix C");
        C.printMatrix();

        Matrix b1 = A.MultiplyBy(C);
        System.out.println("\nMatrix A x C");
        b1.printMatrix();
        Matrix b2 = C.MultiplyBy(A);
        System.out.println("\nMatrix C x A");
        b2.printMatrix();
        */

        Matrix At = A.Transpose();
        At.printMatrix();
    }
}
