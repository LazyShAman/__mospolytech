import junit.framework.TestCase;

public class MatrixTest extends TestCase {

    public void testFillMatrix1() {

    }

    public void testFillRandomMatrix() {
    }

    public void testPrintMatrix() {
    }

    public void testGetElement1() {
        int rows = 5, columns = 5, newElement = 404;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, newElement);
        assertEquals(newElement, A.getElement(2, 3));
    }

    public void testGetElement2() {
        int rows = 5, columns = 5, newElement = 404;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, newElement);
        assertFalse(A.getElement(3, 2) == A.getElement(2, 3));
    }

    public void testGetElement3() {
        int rows = 5, columns = 5, newElement = 404;
        Matrix A = new Matrix(rows, columns);
        A.setElement(3, 2, newElement);
        A.setElement(2, 3, newElement - 1);
        assertTrue(A.getElement(3, 2) > A.getElement(2, 3));
    }

    public void testGetElement4() {
        int rows = 5, columns = 5, firstEl = 404, secondEl = 505;
        Matrix A = new Matrix(rows, columns);
        A.setElement(3, 2, firstEl);
        A.setElement(2, 3, secondEl);
        assertNotSame(firstEl, A.getElement(2, 3));
    }

    public void testGetElement5() {
        int rows = 5, columns = 5, newElement = 404;
        Matrix A = new Matrix(rows, columns);
        A.setElement(3, 2, newElement);
        A.setElement(2, 3, A.getElement(3, 2));
        assertEquals(A.getElement(3, 2), A.getElement(2, 3));
    }

    public void testSetElement() {
    }

    public void testPlus1() {
        int rows = 5, columns = 5, actual = 404, expected = 505;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        B.setElement(2, 3, actual);
        Matrix C = A.Plus(B);
        assertTrue(expected == C.getElement(2, 3));
    }

    public void testPlus2() {
        int rows = 5, columns = 5, actual = 404, expected = actual * 2;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        B.setElement(2, 3, actual);
        Matrix C = A.Plus(B);
        assertTrue(expected == C.getElement(2, 3));
    }

    public void testPlus3() {
        int rows = 5, columns = 5, actual = 404, expected = 505;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        B.setElement(2, 3, actual);
        Matrix C = A.Plus(B);
        assertFalse(expected == C.getElement(2, 3));
    }

    public void testPlus4() {
        int rows = 5, columns = 5, expected = 0;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        Matrix C = A.Plus(B);
        assertEquals(expected, C.getElement(2, 3));
    }

    public void testPlus5() {
        int rows = 5, columns = 5, actual = 404, expected = actual;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        Matrix C = A.Plus(B);
        assertEquals(expected, C.getElement(2, 3));
    }

    public void testMinus1() {
        int rows = 5, columns = 5, firstAct = 404, secondAct = -101, expected = 505;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, firstAct);
        B.setElement(2, 3, secondAct);
        Matrix C = A.Minus(B);
        assertEquals(expected, C.getElement(2, 3));
    }

    public void testMinus2() {
        int rows = 5, columns = 5, actual = 404, expected = 404;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        Matrix C = A.Minus(B);
        assertEquals(expected, C.getElement(2, 3));
    }

    public void testMinus3() {
        int rows = 5, columns = 5, actual = 404, expected = 404;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        Matrix C = B.Minus(A);
        assertEquals(expected, C.getElement(2, 3));
    }

    public void testMinus4() {
        int rows = 5, columns = 5, actual = 404, expected = 404;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        A.setElement(2, 3, actual);
        Matrix C = B.Minus(A);
        assertFalse(expected == C.getElement(2, 3));
    }

    public void testMinus5() {
        int rows = 5, columns = 5, expected = 0;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        Matrix C = A.Minus(B);
        assertEquals(expected, C.getElement(2, 3));
    }


    public void testMultiplyBy1() {
        int rows = 2, columns = 2, expected = 25;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        B.setElement(0, 0, 1);
        B.setElement(0, 1, 3);
        B.setElement(1, 0, 2);
        B.setElement(1, 1, 4);

        Matrix C = A.MultiplyBy(B);
        assertEquals(expected, C.getElement(1, 1));
    }

    public void testMultiplyBy2() {
        int rows = 2, columns = 2, expected = 5;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns-1);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        B.setElement(0, 0, 1);
        B.setElement(1, 0, 2);

        Matrix C = A.MultiplyBy(B);
        assertEquals(expected, C.getElement(0, 0));
    }

    public void testMultiplyBy3() {
        int rows = 2, columns = 2, expected = 5;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns-1);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        B.setElement(0, 0, 1);
        B.setElement(1, 0, 2);

        Matrix C = B.MultiplyBy(A);
        assertEquals(expected, C.getElement(0, 0));
    }

    public void testMultiplyBy4() {
        int rows = 2, columns = 2;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns-1);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        B.setElement(0, 0, 1);
        B.setElement(1, 0, 2);

        Matrix C = B.MultiplyBy(A);
        assertNull(C);
    }

    public void testMultiplyBy5() {
        int rows = 2, columns = 2;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns-1);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        B.setElement(0, 0, 1);
        B.setElement(1, 0, 2);

        Matrix C = B.MultiplyBy(A);
        assertNotNull(C);
    }

    public void testTimes1() {
        int rows = 5, columns = 5, value = 101, X = 4, expected = 404;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, value);
        Matrix B = A.Times(X);
        assertEquals(expected, B.getElement(2, 3));
    }

    public void testTimes2() {
        int rows = 5, columns = 5, value = 101, X = 4, expected = 505;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, value);
        Matrix B = A.Times(X);
        assertEquals(expected, B.getElement(2, 3));
    }

    public void testTimes3() {
        int rows = 5, columns = 5, value = 101, X = 4, expected = 505;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, value);
        Matrix B = A.Times(X);
        assertFalse(expected == B.getElement(2, 3));
    }

    public void testTimes4() {
        int rows = 5, columns = 5, value = 101, X = 4, expected = 505;
        Matrix A = new Matrix(rows, columns);
        A.setElement(2, 3, value);
        Matrix B = A.Times(X);
        assertTrue(expected > B.getElement(2, 3));
    }

    public void testTimes5() {
        int rows = 5, columns = 5, X = 4, expected = 0;
        Matrix A = new Matrix(rows, columns);
        Matrix B = A.Times(X);
        assertEquals(expected, B.getElement(2, 3));
    }

    public void testTranspose1() {
        int rows = 2, columns = 2;
        Matrix A = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                A.setElement(row, column, 1);
            }
        }
        Matrix B = A.Transpose();
        assertSame(A, B);
    }

    public void testTranspose2() {
        int rows = 2, columns = 2;
        Matrix A = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                A.setElement(row, column, 1);
            }
        }
        Matrix B = A.Transpose();
        assertNotSame(A, B);
    }

    public void testTranspose3() {
        int rows = 1, columns = 1;
        Matrix A = new Matrix(rows, columns);
        A.setElement(0, 0, 404);
        Matrix B = A.Transpose();
        assertSame(A, B);
    }

    public void testTranspose4() {
        int rows = 1, columns = 1;
        Matrix A = new Matrix(rows, columns);
        A.setElement(0, 0, 404);
        Matrix B = A.Transpose();
        assertNotSame(A, B);
    }

    public void testTranspose5() {
        int rows = 1, columns = 1;
        Matrix A = new Matrix(rows, columns);
        A.setElement(0, 0, 404);
        Matrix B = A.Transpose().Transpose();
        A.Transpose().Transpose();
        assertSame(A, B);
    }
}