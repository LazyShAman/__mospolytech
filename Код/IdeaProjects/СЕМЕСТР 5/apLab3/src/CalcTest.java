import java.util.Scanner;
import javax.swing.JOptionPane;

public class CalcTest {
    static long time1;
    static long time2;

    public static void main(String[] args) throws Exception {
        Calc c = new Calc();

//        Scanner in = new Scanner(System.in);
        while (true) {
            String name = JOptionPane.showInputDialog(null, "Enter the formula ->", "Title", JOptionPane.QUESTION_MESSAGE);
//            System.out.print("Enter the formula -> ");
            time1 = System.nanoTime();
            String answer = c.compile(name.toCharArray());
            time2 = System.nanoTime();
            JOptionPane.showMessageDialog(null, answer + "\nCompleted in " + (time2 - time1)/1000000 + " ms", "Title", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

