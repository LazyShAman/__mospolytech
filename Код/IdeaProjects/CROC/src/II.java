import java.util.LinkedList;
import java.util.Scanner;

public class II {
    public static void main(String[] args) {
        LinkedList<String> emailList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int groups = n, current = 0, group;
        String email, printedLine, emailSample;
        String[] emails = new String[n];
        int[] amount = new int[n];

        for (int i = 0; i < n+1; i++) {
            email = in.nextLine();
            emailList.addFirst(email);
        }

        group = 0;
        while (!emailList.isEmpty()) {

            emailSample = emailList.getFirst().toLowerCase();
            emailSample = makeSimple(emailSample);

            printedLine = emailList.pop();
            current = 1;
            if (emailList.size() > 0) {
                for (int i = 0; i < emailList.size(); i++) {
                    email = emailList.getFirst().toLowerCase();
                    email = makeSimple(email);

                    if (email.equals(emailSample)) {
                        printedLine += " " + emailList.pop();
                        current++;
                    } else
                        emailList.addLast(emailList.pop());
                }
            }
            emails[group] = printedLine;
            amount[group++] = current;
            groups = groups - current + 1;
        }

        System.out.println(groups);
        for (int i = 0; i < groups; i++) {
            System.out.println(amount[i] + " " + emails[i]);
        }
    }

    public static String makeSimple(String source) {
        if (source.contains("@gmail.com")) {
            source = source.substring(0, source.indexOf('@')).replaceAll("\\.", "")
                    + source.substring(source.indexOf('@'));
            if (source.contains("+"))
                source = source.substring(0, source.indexOf('+'))
                        + source.substring(source.indexOf('+') + 1);
        }
        return source;
    }
}
