// Ctrl + Alt + L

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Random random = new Random();
    static long time1;
    static long time2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This app is designed to work with arrays of random elements");
        System.out.print("Enter the size of array: ");
        int nElems = in.nextInt();
        long[] a = new long[nElems];

        for (int i = 0; i < nElems; i++)
            a[i] = random.nextInt(-1000000, 1000000);

        boolean insSort = true;
        boolean selSort = true;
        boolean merSort = true;
        boolean qckSort = true;

        printArray(a);
        while (true) {
            if (insSort)
                System.out.println("Insertion sort - [1]");
            if (selSort)
                System.out.println("Selection sort - [2]");
            if (merSort)
                System.out.println("Merge sort     - [3]");
            if (qckSort)
                System.out.println("Quick sort     - [4]");

            int operation = in.nextInt();
            switch (operation) {
                case (1) -> {
                    if (!insSort)
                        break;

                    time1 = System.nanoTime();
                    printArray(insertionSort(Arrays.copyOfRange(a, 0, a.length)));
                    time2 = System.nanoTime();

                    System.out.println("\nCompleted in " + (time2 - time1)/1000 + " μs\n");
                    insSort = false;
                }
                case (2) -> {
                    if (!selSort)
                        break;

                    time1 = System.nanoTime();
                    printArray(selectionSort(Arrays.copyOfRange(a, 0, a.length)));
                    time2 = System.nanoTime();

                    System.out.println("\nCompleted in " + (time2 - time1)/1000 + " μs\n");
                    selSort = false;
                }
                case (3) -> {
                    if (!merSort)
                        break;

                    time1 = System.nanoTime();
                    printArray(mergeSort(Arrays.copyOfRange(a, 0, a.length)));
                    time2 = System.nanoTime();

                    System.out.println("\nCompleted in " + (time2 - time1)/1000 + " μs\n");
                    merSort = false;
                }
                case (4) -> {
                    if (!qckSort)
                        break;

                    time1 = System.nanoTime();
                    printArray(quickSort(Arrays.copyOfRange(a, 0, a.length)));
                    time2 = System.nanoTime();

                    System.out.println("\nCompleted in " + (time2 - time1)/1000 + " μs\n");
                    qckSort = false;
                }
                case (5) -> {
                    printArray(a);
                }
                default -> {
                    System.exit(0);
                }
            }
        }
    }

    public static void printArray(long[] arr) {
        System.out.println("\nArray: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    // время выполнения - O(N^2)
    public static long[] insertionSort(long[] arr) {
        long temp;
        int i, j;

        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                if (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                } else
                    break;
            }
            arr[j] = temp;
        }
        return arr;
    }

    // количество перестановок - O(N)
    // время выполнения - O(N^2)
    public static long[] selectionSort(long[] arr) {
        int min;
        long temp;

        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            if (min != i) {
                temp = arr[min];
                arr[i] = temp;
                arr[min] = arr[i];
            }
        }

        return arr;
    }

    // время выполнения - O(N^2)
    public static long[] mergeSort(long[] arr) {
        if (arr.length == 1) return arr;
        int middle = arr.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)),
                mergeSort(Arrays.copyOfRange(arr, middle, arr.length)));
    }

    private static long[] merge(long[] arrLeft, long[] arrRight) {
        int cLeft = 0, cRight = 0, len = arrLeft.length + arrRight.length; // cLeft, cRight - counters in arrays
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            if (cRight < arrRight.length && cLeft < arrLeft.length) {
                if (arrLeft[cLeft] > arrRight[cRight]) result[i] = arrRight[cRight++];
                else result[i] = arrLeft[cLeft++];
            } else if (cRight < arrRight.length) {
                result[i] = arrRight[cRight++];
            } else {
                result[i] = arrLeft[cLeft++];
            }
        }
        return result;
    }

    // время выполнения - O(N * log N)
    public static long[] quickSort(long[] arr) {
//        time1 = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
//        time2 = System.nanoTime();
        return arr;
    }

    private static void quickSort(long[] source, int left, int right) {
        // end if array is empty or there is nothing to divide
        if (source.length == 0 || left >= right) return;

        // picking a border
        int delimiter = left + (right - left) / 2;
        long border = source[delimiter];

        // dividing to sub-arrays and swapping
        int i = left, j = right;
        long swap;
        while (i <= j) {
            while (source[i] < border) i++;
            while (source[j] > border) j--;
            if (i <= j) {
                swap = source[i];
                source[i] = source[j];
                source[j] = swap;
                i++;
                j--;
            }
        }

        // recursion to sort left and right sides
        if (left < j) quickSort(source, left, j);
        if (right > i) quickSort(source, i, right);
    }
}