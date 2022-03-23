package labs.week3.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        Scanner scanner = new Scanner(System.in);

        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("END")) {
                break;
            }

            String[] words = line.split("\\s+");
            if (words.length == 0) {
                continue;
            }
            CommandExecutor executor = new CommandExecutor(fileManagement);
            executor.execute(words);
        }
    }
}
