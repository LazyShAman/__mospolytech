import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        /* STACK 1 */
        Stack st1 = new Stack(15);
        st1.push('4');
        st1.push('5');
        st1.push('6');
        System.out.println(st1.getSize());

        System.out.println("***");

        /* STACK 2 */
        String l1 = "c[d]";
        hooks(l1);
        String l2 = "a{b[c]d}e";
        hooks(l2);
        String l3 = "a{b(c]d}e";
        hooks(l3);
        String l4 = "a[b{c}d]e}";
        hooks(l4);
        String l5 = "a{b(c)";
        hooks(l5);

        System.out.println("***");

        /* QUEUE */
        Queue qu1 = new Queue(15);
        qu1.push(5);
        qu1.push(3);
        qu1.push(4);
        qu1.pop();
        System.out.println(qu1.getSize());

        for (int i = 0; i < qu1.getSize(); i++) {
            int val = qu1.pop();
            qu1.push(val);
            System.out.print(" " + val);
        }

        System.out.println();
        System.out.println("***");

        /* DEQUE */
        Deque deq1 = new Deque(5);
        deq1.pushFront(5);
        deq1.pushBack(3);
        deq1.pushBack(4);
        deq1.pushFront(1);
        deq1.pushFront(9);
        deq1.popFront();
        deq1.pushFront(72);
        //deq1.popBack();

        System.out.println(deq1.getSize());
        /*
        System.out.println(deq1.front());
        System.out.println(deq1.back());
         */

        for (int i = 0; i < deq1.getSize(); i++) {
            int val = deq1.popFront();
            deq1.pushBack(val);
            System.out.print(" " + val);
        }
        System.out.println();
        for (int i = 0; i < deq1.getSize(); i++) {
            int val = deq1.popBack();
            deq1.pushFront(val);
            System.out.print(" " + val);
        }

        System.out.println();
        String str = in.nextLine();
        String sub = "";
        while (!sub.equals("*")) {
            palindrome(str);
            sub = in.nextLine();
            str += sub;
        }
    }

    public static void hooks(String line) throws Exception {
        Stack st2 = new Stack(line.length());
        boolean flag = true;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(' || line.charAt(i) == '{' || line.charAt(i) == '[')
                st2.push(line.charAt(i));

            if ((line.charAt(i) == ')' || line.charAt(i) == '}' || line.charAt(i) == ']') && st2.empty()) {
                flag = false;
                break;
            }

            if (line.charAt(i) == ')') {
                if (st2.top() == '(')
                    st2.pop();
                else {
                    flag = false;
                    break;
                }
            }

            if (line.charAt(i) == '}') {
                if (st2.top() == '{')
                    st2.pop();
                else {
                    flag = false;
                    break;
                }
            }

            if (line.charAt(i) == ']') {
                if (st2.top() == '[')
                    st2.pop();
                else {
                    flag = false;
                    break;
                }
            }
        }

        if (!st2.empty())
            flag = false;
        System.out.print("The line " + line + " is " + flag + "\n");
    }

    public static void palindrome(String str) throws Exception {
        boolean flag = true;
        String line;

        if (str.length() % 2 == 1)
            line = str.substring(0, str.length() / 2) + str.substring(str.length() / 2 + 1);
        else
            line = str;

        Deque deq1 = new Deque(line.length());
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
