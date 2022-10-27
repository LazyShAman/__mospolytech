import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int k = 0;
        int counter = 0;

        /* в дальнейшем можно заменить k < 7 на true,
           сделав таким образом цикл бесконечным
           с внутренним условием при вводе "*"
           вместо указанных комбинаций */
        while (k < 7) {
            String line = in.nextLine();

            if (line.startsWith("Run ")) {
                list1.addFirst(line.substring(4));
                counter++;
                System.out.println(list1.getFirst());
            } else if (line.startsWith("Alt+")) {
                if (line.substring(4).equals("Delete")) {
                    list1.removeFirst();
                    counter--;
                } else {
                    line = line.substring(4);
                    int tab = 0;
                    for (int i = 0; i < line.length(); i += 4) {
                        if (line.startsWith("Tab", i))
                            tab++;
                    }
                    System.out.println(list1.get(tab % counter));
                    String val = list1.remove(tab % counter);
                    list1.addFirst(val);
                }
            }
            k++;
        }
    }
}
