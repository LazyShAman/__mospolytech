import java.util.Scanner;

public class array7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int N = in.nextInt();
        int[] a = new int[N];

        System.out.print("Enter 0 to fill the array with random values or 1 to enter values manually: ");
        int flag = in.nextInt();
        if (flag == 0) {
            for (int i = 0; i < N; i++) {
                a[i] = (int) (Math.random() * 100);
            }
        } else if (flag == 1) {
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
        } else {
            System.out.print("There is no such option");
        }

        if (flag == 0 || flag == 1) {
            for (int i = N - 1; i > -1; i--) {
                System.out.printf("%s ", a[i]);
            }
        }
    }
}