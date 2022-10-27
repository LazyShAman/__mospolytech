import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Random random = new Random();
    static long time1;
    static long time2;
    private static long[] a; // Ссылка на массив a
    private static int nElems; // Количество элементов в массиве

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This app is designed to work with arrays of random elements");

        System.out.print("Enter the size of array: ");
        nElems = in.nextInt();

        a = new long[nElems];
        int i;
        for (i = 0; i < nElems; i++)
            a[i] = random.nextInt(-1000000, 1000000);

        System.out.print("Should the array be sorted? [enter 1] ");
        int answer = in.nextInt();

        boolean sorted = answer == 1;

        if (sorted)
            Arrays.sort(a);

        printArray();

        while (true) {
            System.out.println("\nSearch - [1] \nInsert - [2] \nDelete - [3] ");
            if (sorted)
                System.out.println("Binary - [4]");

            int operation = in.nextInt();
            switch (operation) {
                case (1) -> {
                    System.out.print("\nPlease enter the search key: ");
                    long usersSearchKey = in.nextInt();
                    time1 = System.nanoTime();
                    boolean isFound = search(usersSearchKey);
                    time2 = System.nanoTime();

                    if (isFound) {
                        System.out.println("The element is successfully found!");
                        System.out.println("Completed in " + (time2 - time1));
                    } else
                        System.out.println("The element does not exist!");
                }
                case (4) -> {
                    if (!sorted)
                        break;
                    System.out.print("\nPlease enter the search key: ");
                    long usersBinarySearchKey = in.nextInt();
                    time1 = System.nanoTime();
                    int elementPosition = binarySearch(usersBinarySearchKey);
                    time2 = System.nanoTime();

                    if (elementPosition < nElems) {
                        System.out.println("The element is found on position " + elementPosition);
                        System.out.println("Completed in " + (time2 - time1));
                    } else
                        System.out.println("The element does not exist!");
                }
                case (2) -> {
                    System.out.print("\nPlease enter the value of the element to be added: ");
                    long usersInsertValue = in.nextInt();
                    time1 = System.nanoTime();
                    if (sorted) {
                        insertInSorted(usersInsertValue);
                        time2 = System.nanoTime();
                    } else {
                        insert(usersInsertValue);
                        time2 = System.nanoTime();
                    }
                    System.out.println("The element is successfully added!");
                    System.out.println("Completed in " + (time2 - time1));
                    printArray();
                }
                case (3) -> {
                    System.out.print("\nPlease enter the value of the element to be removed: ");
                    long usersDeleteValue = in.nextInt();
                    time1 = System.nanoTime();
                    boolean isDeleted = delete(usersDeleteValue);
                    time2 = System.nanoTime();
                    if (isDeleted) {
                        System.out.println("The element is successfully removed!");
                        System.out.println("Completed in " + (time2 - time1));
                        printArray();
                    } else
                        System.out.println("The element does not exist!");
                }
                default -> {
                    System.exit(0);
                }
            }
        }
    }

    public static void printArray() {
        System.out.println("\nArray: ");
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i]);
            if (i < nElems - 1)
                System.out.print(", ");
        }
    }

    // Поиск заданного значения
    public static boolean search(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        return j != nElems;
    }

    public static int binarySearch(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else { // Деление диапазона
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    // Вставка элемента в массив
    public static void insert(long value) {
        a = Arrays.copyOf(a, nElems + 1);
        a[nElems] = value;
        nElems++;
    }

    public static void insertInSorted(long value) {
        int j;
        a = Arrays.copyOf(a, nElems + 1);
        for (j = 0; j < nElems; j++)
            if (value < a[j])
                break;

        int k;
        for (k = nElems; k > j; k--)
            a[k] = a[k - 1];

        a[j] = value;
        nElems++;
    }

    // Удаление элемента из массива
    public static boolean delete(long value) {
        int j;
        // Поиск заданного значения
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;

        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems - 1; k++)
                a[k] = a[k + 1];

            a = Arrays.copyOf(a, nElems - 1);
            nElems--;
            return true;
        }
    }
}
