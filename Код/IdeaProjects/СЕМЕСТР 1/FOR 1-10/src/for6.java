import java.util.Scanner;

public class for6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double price = in.nextDouble();

        for (int i = 1; i <= 5; i++) {
            System.out.println(price * (i * 0.2 + 1));
        }
    }
}