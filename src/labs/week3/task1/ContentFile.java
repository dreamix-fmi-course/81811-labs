package labs.week3.task1;

import java.time.LocalDate;

public class ContentFile extends File {
    private static final String copyFileName = "%s_(%d)";
    private static int copyFileCounter = 0;

    private String content;

    public ContentFile(String name, String location, LocalDate creationDate, String content) {
        super(name, location, creationDate);
        this.content = content;
    }


    @Override
    public File copy(String newLocation) {
        copyFileCounter++;

        return new ContentFile(
            String.format(copyFileName, this.getName(), copyFileCounter),
            newLocation,
            this.getCreationDate(), this.content);
    }

    @Override
    public void execute() {
        System.out.println("This file cannot be executed");
    }

    @Override
    public void modify(String newData) {
        this.content = newData;
    }

    @Override
    public String getInfo() {
        return String.format("Name: %s%n", this.getName()) +
               String.format("Created: %s%n", this.getCreationDate().toString()) +
               String.format("Location: %s%n", this.getLocation());
    }
}
