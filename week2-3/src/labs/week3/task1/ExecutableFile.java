package labs.week3.task1;

import java.time.LocalDate;
import java.util.List;

public class ExecutableFile extends File {

    private final List<String> resources;
    private LocalDate lastExecutionDate;

    public ExecutableFile(String name, String location, LocalDate creationDate,
                          List<String> resources, LocalDate lastExecutionDate) {
        super(name, location, creationDate);
        this.resources = resources;
        this.lastExecutionDate = lastExecutionDate;
    }

    @Override
    public File copy(String newLocation) {
        copyFileCounter++;

        return new ExecutableFile(
            String.format(copyFileName, this.getName(), copyFileCounter),
            newLocation,
            this.getCreationDate(), this.resources, this.lastExecutionDate);
    }


    public void execute() {
        this.lastExecutionDate = LocalDate.now();
        System.out.println("Executing " + this.getName());
    }

    @Override
    public void modify(String newData) {
        System.out.println("This file is executable. It cannot be modified");
    }


    @Override
    public String getInfo() {
        return String.format("Name: %s%n", this.getName()) +
               String.format("Created: %s%n", this.getCreationDate().toString()) +
               String.format("LastExecuted: %s%n", this.lastExecutionDate) +
               String.format("Location: %s%n", this.getLocation());
    }
}
