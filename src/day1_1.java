import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1_1 {
    public static void main(String[] args) {
        String sourceFile = "src_2";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(sourceFile));
            int sum = 0;
            while (sc.hasNext()) {
                int current = Integer.parseInt(sc.nextLine().trim())/3-2;
                sum += current;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
