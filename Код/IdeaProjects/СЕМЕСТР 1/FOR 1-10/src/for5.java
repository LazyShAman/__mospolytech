import java.util.Scanner;

public class for5 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        double price = in.nextDouble();
        double R = 0;
        for (int i = 1; i <= 10; i++){
            R = price * i * 0.1;
            System.out.println(R);
        }
    }
}