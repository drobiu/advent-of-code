import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2_1 {

    public static void main(String[] args) {
        String fileName = "src_2";

        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
            sc.useDelimiter(",");

            List<Integer> commands = new ArrayList<>();

            while (sc.hasNext()) {
                commands.add(sc.nextInt());
            }

            int pointer = 0;

            while (commands.get(pointer) != 99) {
                if (commands.get(pointer) == 1) {
                    commands.set(commands.get(pointer + 3), commands.get(commands.get(pointer + 1)) + commands.get(commands.get(pointer + 2)));
                    pointer += 4;
                } else if (commands.get(pointer) == 2) {
                    commands.set(commands.get(pointer + 3), commands.get(commands.get(pointer + 1)) * commands.get(commands.get(pointer + 2)));
                    pointer += 4;
                }
            }

            System.out.println(commands.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sc.close();
        }
    }
}
