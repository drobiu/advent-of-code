import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1_2 {
    public static int fuelCounter(int mass) {
        mass = mass / 3 - 2;
        if (mass <= 0)
            return 0;
        return mass + fuelCounter(mass);
    }

    public static void main(String[] args) {
        String sourceFile = "src_2";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(sourceFile));
            int sum = 0;
            while (sc.hasNext()) {
                int current = Integer.parseInt(sc.nextLine());
                sum += fuelCounter(current);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
