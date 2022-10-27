// Ctrl + Shift + Alt + L

import java.util.Scanner;

public class Matrix {
    // final means this class cannot be subclassed, i.e. inheritance prohibited (запрещено наследование)
    private int[][] Matrix;
    private int rows, columns;

    public Matrix(int M, int N) {
        this.rows = M;
        this.columns = N;
        this.Matrix = new int[this.rows][this.columns];
    }

    public Matrix() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of matrix:");
        this.rows = in.nextInt();
        this.columns = in.nextInt();
        this.Matrix = new int[this.rows][this.columns];
    }

    public void fillMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Fill in the matrix of [%s][%s]:\n", this.rows, this.columns);
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.Matrix[row][column] = in.nextInt();
            }
        }
    }

    public void fillRandomMatrix() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.Matrix[row][column] = (int) (Math.random() * 10);
            }
        }
    }

    public void printMatrix() {
        if (this.rows > 0 && this.columns > 0) {
            System.out.println("The matrix is");
            for (int row = 0; row < this.rows; row++) {
                for (int column = 0; column < this.columns; column++) {
                    System.out.printf("%5s", this.Matrix[row][column]);
                }
                System.out.println();
            }
        } else
            System.out.println("Matrix does not exist");
    }

    public int getElement(int row, int column) {
        return this.Matrix[row][column];
    }

    public void setElement(int row, int column, int newElement) {
        this.Matrix[row][column] = newElement;
    }

    public Matrix Plus(Matrix subsidiary) {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.columns == subsidiary.columns && this.rows == subsidiary.rows) {
            for (int row = 0; row < this.rows; row++) {
                for (int column = 0; column < this.columns; column++) {
                    result.setElement(row, column, this.Matrix[row][column] + subsidiary.getElement(row, column));
                }
            }
        } else {
            System.out.println("Error. Cannot summarize");
            result.columns = 0;
            result.rows = 0;
        }
        return result;
    }

    public Matrix Minus(Matrix subsidiary) {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.columns == subsidiary.columns && this.rows == subsidiary.rows) {
            for (int row = 0; row < this.rows; row++) {
                for (int column = 0; column < this.columns; column++) {
                    result.setElement(row, column, this.Matrix[row][column] - subsidiary.getElement(row, column));
                }
            }
        } else {
            System.out.println("Error. Cannot subtract");
            result.columns = 0;
            result.rows = 0;
        }
        return result;
    }

    public Matrix MultiplyBy(Matrix subsidiary) {
        Matrix result = new Matrix(this.rows, subsidiary.columns);
        if (this.columns == subsidiary.rows) {
            for (int row = 0; row < this.rows; row++) {
                for (int column = 0; column < subsidiary.columns; column++) {
                    int newElement = 0;
                    for (int sub = 0; sub < this.columns; sub++) {
                        newElement += this.Matrix[row][sub] * subsidiary.getElement(sub, column);
                    }
                    result.setElement(row, column, newElement);
                }
            }
        } else {
            System.out.println("Error. Cannot multiply");
            result.columns = 0;
            result.rows = 0;
        }
        return result;
    }

    public Matrix Times(int X) {
        Matrix result = new Matrix(this.rows, this.columns);
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                int newElement = this.Matrix[row][column] * X;
                result.setElement(row, column, newElement);
            }
        }
        return result;
    }

    public Matrix Transpose() {
        Matrix result = new Matrix(this.columns, this.rows);
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                result.setElement(column, row, this.getElement(row, column));
            }
        }
        return result;
    }
}