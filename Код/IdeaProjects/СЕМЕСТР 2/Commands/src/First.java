import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stroka = "";
        String str;
        boolean equals = false;
        System.out.println("Вводите значения через пробел. Для завершения введите *.");

        while (true) {
            str = in.nextLine();
            if (str.startsWith("*"))
                break;
            stroka += " " + str;

            String[] array = stroka.split(" ");
            int[] mass = new int[array.length];
            for (int i = 1; i < array.length; i++) {
                mass[i-1] = Integer.parseInt(array[i]);
            }

            for (int even = 0; even < mass.length; even += 2) {
                for (int odd = 1; odd < mass.length; odd += 2) {
                    if (mass[even] == mass[odd]) {
                        equals = true;
                        break;
                    }
                }
            }

            if (equals)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}