import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class List1 {
    public static void main(String[] args) throws Exception {
        FileReader fileread = new FileReader("E:\\grouplist.txt");
        Scanner enter = new Scanner(fileread);

        int search = (new Date()).getYear() + 1880 + 1;
        System.out.println(search);
        int count = 0;
        while (enter.hasNextLine()) {
            String line = enter.nextLine();
            String[] arr = line.split(":");
            arr[1] = arr[1].replaceAll(" ", "");
            if (arr[1].equals("")) {
                arr[1] += search;
            }
            if (Integer.parseInt(arr[1]) < search) {
                count++;
            }
        }
        fileread.close();
        System.out.println(count);
    }
}
