import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2_2 {
    public static void main(String[] args) {
        String fileName = "src_2";

        Scanner sc = null;

        try {
            sc = new Scanner(new File(fileName));
            sc.useDelimiter(",");

            List<Integer> commands = new ArrayList<>();
            List<Integer> commandsCopy = new ArrayList<>();

            while (sc.hasNext()) {
                commands.add(sc.nextInt());
            }

            for (int i = 0; i < commands.size(); i++) {
                commandsCopy.add(commands.get(i));
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < commands.size(); k++) {
                        commands.set(k, commandsCopy.get(k));
                    }

                    commands.set(1, i);
                    commands.set(2, j);

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

                    if (commands.get(0) == 19690720) {
                        System.out.println(100 * i + j);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sc.close();
        }
    }
}
