import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String sub = "";
        while (!sub.equals("*")) {
            palindrome(str);
            sub = in.nextLine();
            str += sub;
        }
    }

    public static void palindrome(String str) throws Exception {
        boolean flag = true;
        String line;

        if (str.length() % 2 == 1)
            line = str.substring(0, str.length() / 2) + str.substring(str.length() / 2 + 1);
        else
            line = str;

        Deq deq1 = new Deq(line.length());
        for (int i = 0; i < line.length(); i++) {
            int x = line.charAt(i);
            deq1.pushBack(x);
        }

        for (int i = 0; i < line.length() / 2; i++) {
            if (deq1.front() == deq1.back()) {
                deq1.popFront();
                deq1.popBack();
            } else {
                flag = false;
                break;
            }
        }

        if (!deq1.empty())
            flag = false;

        System.out.println("The " + str + " is palindrome: " + flag);
    }
}
