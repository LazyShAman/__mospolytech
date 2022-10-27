import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        L1List list1 = new L1List();
        list1.toFront();
        int k = 0;
        int counter = 0;

        /* в дальнейшем можно заменить k < 7 на true,
           сделав таким образом цикл бесконечным
           с внутренним условием при вводе "*"
           вместо указанных комбинаций */
        while (k < 7) {
            String line = in.nextLine();

            if (line.startsWith("Run ")) {
                list1.insert(line.substring(4));
                counter++;
                System.out.println(list1.after());
            } else if (line.startsWith("Alt+")) {
                if (line.substring(4).equals("Delete")) {
                    list1.erase();
                    counter--;
                } else {
                    line = line.substring(4);
                    int tab = 0;
                    for (int i = 0; i < line.length(); i += 4) {
                        if (line.startsWith("Tab", i))
                            tab++;
                    }
                    tab %= counter;
                    for (int i = 0; i < tab; i++) {
                        list1.forward();
                    }
                    System.out.println(list1.after());
                    String val = list1.erase();
                    list1.toFront();
                    list1.insert(val);
                }
            }
            k++;
        }
    }
}
