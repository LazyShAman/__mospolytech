import java.io.FileReader;
import java.util.Scanner;

public class List3 {
    public static void main(String[] args) throws Exception {
        FileReader fileread = new FileReader("E:\\grouplist.txt");
        Scanner enter = new Scanner(fileread);

        String search = "(494)";

        while (enter.hasNextLine()) {
            String line = enter.nextLine();
            String[] arr = line.split(":");

            if (arr[2].contains(search)) {
                String[] SNP = arr[0].split(" ");
                System.out.println(SNP[0]);
            }
        }
        fileread.close();
    }
}
