package labs.week3.task1;


import java.util.Arrays;

public class CommandExecutor {

    private final FileManagement fileManagement;

    public CommandExecutor(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    public void execute(String... command) {
        String[] args = Arrays.copyOfRange(command, 1, command.length);
        switch (command[0]) {
            case "MAKE" -> fileManagement.makeFile(args);
            case "DELETE" -> fileManagement.delete(args);
            case "MODIFY" -> fileManagement.modify(args);
            case "EXECUTE" -> fileManagement.execute(args);
            case "COPY" -> fileManagement.copy(args);
            case "INFO" -> fileManagement.getInfo(args);
            case "MOVE" -> fileManagement.move(args);
            default -> System.out.println("Invalid command");
        }
    }
}
